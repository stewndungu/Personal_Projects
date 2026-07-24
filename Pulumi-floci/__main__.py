"""An AWS Python Pulumi program"""

import pulumi
from pulumi_aws import s3,iam,ecr,secretsmanager,ecs

"""
Original setup when starting out. The ecs_execution_role_policy was commented out.

# Create an AWS resource (S3 Bucket)
bucket = s3.Bucket('my-bucket-5d36f66')

# 2. IAM Role for ECS Task Execution
ecs_execution_role = iam.Role("ecs-execution-role",
    assume_role_policy= 
    
    {
        "Version": "2012-10-12",
        "Statement": [
            {
                "Action": "sts:AssumeRole",
                "Principal": {
                    "Service": "://amazonaws.com"
                },
                "Effect": "Allow",
                "Sid": ""
            }
        ]
    }

)

# 3. ECR Container Repository
ecr_repo = ecr.Repository("my-ecr-repo",
    image_tag_mutability="MUTABLE"
)

# 4. Secrets Manager Secret
secret = secretsmanager.Secret("my-local-secret",
    description="A local mock secret in Floci"
)

# 5. ECS Cluster
ecs_cluster = ecs.Cluster("y-cluster-54ad4f6")

# Export the name of the bucket
pulumi.export('bucket_name', bucket.id)
pulumi.export("ecr_url", ecr_repo.repository_url)
pulumi.export("secret_arn", secret.arn)
pulumi.export("ecs_cluster_name", ecs_cluster.name)

"""

stack = pulumi.get_stack()

if not stack.startswith("pr-"):
    # -- shared infra, deployed once as the "development" stack --
    bucket = s3.Bucket("pr-envs")
    repo = ecr.Repository("my-ecr-repo", image_tag_mutability="MUTABLE")
    cluster = ecs.Cluster("dev-cluster")
    base = secretsmanager.Secret("base-secret")
    secretsmanager.SecretVersion("base-secret-v",
        secret_id=base.id, secret_string='{"DB_URL":"postgres://dev"}')
    pulumi.export("bucket_name", bucket.id)
    pulumi.export("base_secret_id", base.id)

else:
    # -- per-PR child: pr-42, pr-43, ... --
    pr = stack.removeprefix("pr-")
    dev = pulumi.StackReference("development")  # local backend: just the name
    bucket_name = dev.get_output("bucket_name")

    s3.BucketObjectv2("prefix-marker",
        bucket=bucket_name, key=f"pr-{pr}/.keep", content="")

    base_val = secretsmanager.get_secret_version_output(
        secret_id=dev.get_output("base_secret_id"))          # = clone_exact
    pr_secret = secretsmanager.Secret("pr-secret", name=f"pr-{pr}/app-config")
    secretsmanager.SecretVersion("pr-secret-v",
        secret_id=pr_secret.id, secret_string=base_val.secret_string)
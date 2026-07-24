"""An AWS Python Pulumi program"""

import pulumi
from pulumi_aws import s3,iam,ecr,secretsmanager,ecs

# Create an AWS resource (S3 Bucket)
bucket = s3.Bucket('my-bucket-5d36f66')

# 2. IAM Role for ECS Task Execution
ecs_execution_role = iam.Role("ecs-execution-role",
    assume_role_policy="""{
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
    }"""
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

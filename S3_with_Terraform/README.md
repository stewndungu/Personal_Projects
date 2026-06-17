# Table of contents
- [Introduction](#introduction)
- [Steps Taken](#steps-taken)
- [Reflections](#reflections)


# Introduction

Hello, this is a beginner project in understanding an setting up Terraform. The purpose of this is to understand how terraform works especially with AWS for a recent DevOps internship. 

# Steps Taken

First, I am following the learn.nextwork.org project -> Creating S3 buckets with Terraform.
Secondly, I am trying to slowly build and rebuild sections to grasp the concepts.

1. If you are like me and are using the github codespace on the browser
    - follow this link for the tutorial to get terraform up and running
        -https://hasangural.com/github-codespaces-terraform

    - if that did not work for you
        - enter this in the devcontainer.json
            -{
                "image": "mcr.microsoft.com/devcontainers/universal:linux",
                "features": {
                    "ghcr.io/devcontainers/features/terraform:1": {
                    "version": "latest"
                    }
                },
                "customizations": {
                    "vscode": {
                    "extensions": [
                        "hashicorp.terraform"
                    ]
                    }
                }
            }
        - then rebuild by typing
            - "> rebuild"
            - click the option given 
            - continue and click rebuild

# Reflections
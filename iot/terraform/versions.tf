terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "5.19.0"
    }
  }
  backend "s3" {
    bucket = "glolabs-terraform-state"
    key    = "verkundenbot"
    region = "us-east-1"
    profile = "tf-svc-user-verkundenbot"
  }
}
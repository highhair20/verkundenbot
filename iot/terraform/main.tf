terraform {
  backend "s3" {
    profile         = "tf-svc-user"
    dynamodb_table  = "terraform_state"
  }
}

provider "aws" {
  profile = "${var.aws_profile}"
  region = "${var.aws_region}"

  assume_role {
    role_arn = "arn:aws:iam::${var.aws_account_id}:role/tf-svc-role-vkb-iot"
  }
}

module "vkb_iot_module_resources" {
  source = "./thing/"

  device_id = var.device_id
  client_id = var.client_id
}

# IoT Cloud Infrastructure
___
This section of the Verkündenbot project focuses on the required AWS IoT resources. 
This portion of the project assumes the Terraform backend state is managed in AWS s3
and DynamoDB. To see detailed instructions on setting up a remote backend look
[here](https://github.com/highhair20/terraform-backend-s3).

## Before You Begin

### Create an IAM Role 
Create a role so that ```tf-svc-user``` can create the Verkündenbot IoT resources in AWS.
1. In the AWS console click "Create role" > "Custom trust policy" and paste the following json. This  
   establishes a trust relationship with the terraform service user and the role that allows the creation of the 
   resources required for the IoT resources.
   ```json
   {
       "Version": "2012-10-17",
       "Statement": [
           {
               "Effect": "Allow",
               "Principal": {
                   "AWS": "arn:aws:iam::<YOUR AWS ACCOUNT ID>:user/tf-svc-user"
               },
               "Action": "sts:AssumeRole"
           }
       ]
   }
   ```
2. Click "Next" > "Next"
3. Enter a Role name such as ```tf-svc-role-vkb-iot``` and click "Create role"
4. Locate the role you just created and click "Add permissions" > "Create inline policy" > "JSON"
   Paste the following JSON. Make sure and replace "\<YOUR AWS ACCOUNT ID>" with your 
   actual AWS account id:
   ```json
   {
       "Version": "2012-10-17",
       "Statement": [
           {
				"Effect": "Allow",
				"Action": [
                    ""
                ],
                "Resource": [
					"*"
                ]
           }
       ]
   }
   ```
5. Click "Next". Give the policy a name such as ```tf-svc-policy-vkb-iot``` and click > "Create policy".









## IoT Project
### Execute terraform commands
From the root of the project:
```
cd verkundenbot/iot
terraform init -backend-config=backend.conf
terraform plan 
terraform apply
```










---





## What resources are created

1. things for each device id
2. thing-certificate
3. thing-policy
4. thing-assume-with-cert-policy
5. thing-service-role to access aws services via thing-certificate
6. thing-service-role-alias
7. thing-shadow-rule to sending shadow data to s3 bucket
8. thing-aws-resources
    1. thing-deployment-bucket: 
    2. thing-shadow-bucket
    3. thing-shadow-table to querying shadow data from athena
9. thing-deploy-policy
10. thing-deploy-role to access aws resources with role
11. thing-deploy-user to access aws resources with user
12. thing-configurations
    1. thing-certificate as file
    2. thing-certificate-public-key as file
    3. thing-certificate-private-key as file
    4. conf.json

conf.json
```
{
    "devices": ["dev-gorup-dev-id"],
    "thingGroup": "dev-gorup",
    "region": "us-east-1",
    "roleAlias": "my-dev-gorup-service-role-alias",
    "deploymentBucket": "org-thing-my-dev-group-deployment",
    "version": "2020-06-12-21-41-36"
}
```

## Usage

uncomment terraform backend config in main.tf if you want to keep states in a s3 bucket

```
terraform {
  backend "s3" {
    bucket = "my-terraform-bucket"
    key    = "terraform/terraform.tfstate"
    region = "us-east-1"
  }
}
```

run terraform commands
```
terraform init

terraform plan -var 'device_ids=["dev-id"]' -var 'project_name=org' -var 'thing_group=dev-group'

terraform apply -var 'device_ids=["dev-id"]' -var 'project_name=org' -var 'thing_group=dev-group'
```

* device_ids: list of unique device ids
* thing_group: name of the device group
* project_name: name of the project/product

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Related Documents
How to access aws resources with AWS IOT certificate and private key

https://aws.amazon.com/blogs/security/how-to-eliminate-the-need-for-hardcoded-aws-credentials-in-devices-by-using-the-aws-iot-credentials-provider/
















Before beginning have the following information ready. You will be prompted for 
them during the terraform plan, apply and destroy steps.
 * aws_account_id
 * aws_profile (Read more [here](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-files.html))
 * aws_region (ex: us-east-1)



To avoid having to enter the values each time you run a terraform command you can 
create a ```terraform.tfvars``` file ([ref](https://www.virtualizationhowto.com/2022/05/terraform-prompt-for-variable-input-when-creating-a-virtual-machine/)). 
However, I do not recommend checking the file in to git.

From the root of the project run the following Terraform commands.
```
cd ./iot/terraform

terraform init -backend-config=backend.conf

terraform plan

terraform apply
```





# verkundenbot-cloud

Verkundenbot Cloud is a Java Spring Boot REST API that runs on an 
AWS Lambda behind API Gateway. It persists all actions and state to a
database and publishes state to an IoT shadow.  

The REST API is public facing and is used by web hooks (like Datadog) to change state. 
The API is also called by the webapp to identify current states of verkundenbot-device 
and to trigger state changes. Suported calls are POST, PUT and GET.


## Overview  

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties


## Endpoints

Endpoints include the following:
* GET /device
* GET /device/{id}
* POST /device
* PUT /device/{id}
* PUT /node/{id}
    * saves event to RDS
    * publishes event to SQS
* GET /node/{id}
    * saves event to RDS
    * publishes event to SQS



* POST /alert/pixel-alarm
    * saves event to RDS
    * publishes event to SQS
* POST /alert/free-speach
    * saves event to RDS
    * publishes event to SQS
  
    
    
Reference:
* https://www.baeldung.com/spring-boot-console-app
* https://www.programcreek.com/java-api-examples/?code=aws%2Faws-iot-device-sdk-java%2Faws-iot-device-sdk-java-master%2Faws-iot-device-sdk-java-samples%2Fsrc%2Fmain%2Fjava%2Fcom%2Famazonaws%2Fservices%2Fiot%2Fclient%2Fsample%2FpubSub%2FPublishSubscribeSample.java

TODO - integrate lombok
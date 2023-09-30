## IoT Cloud Infrastructure

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

terraform init

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
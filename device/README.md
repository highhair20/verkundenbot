# Verkündenbot Device

The Verkündenbot Device is an AWS IoT enabled device.
The messages determine the state of the physical device.

## Hardware
For the purposes of this project I used a RaspberryPi 2 I had lying around.
Create the directory where the software will live and get the latest git checkout.
```
sudo git clone https://github.com/highhair20/verkundenbot.git /opt/verkundenbot
```

## IoT Cloud Infrastructure

Before beginning have the following information ready:
 * aws_account_id
 * aws_profile (Read more [here](https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-files.html))
 * aws_region (ex: us-east-1)

From the root of the project run the following Terraform commands.
```
cd ./iot/terraform

terraform init

terraform plan

terraform apply
```


## Interfaces

#### Who will be communicating with Verkundenbot?
* __Deployments (Jenkings or AWS CodeBuild)__ - When we deploy code we want to notify the device so that we get an audible
alerting on what system was update and who made the change.
* __Verkundenbot Web App__ - There is a React web app where you can interect with the device.
You can control plugs A, B and C and you can send custom messages which will be converted
to voice and send through the speakers. 

#### How will the sources interact?
How will each source interact with the API and what do the 
requests look like?
* __Datadog__ - 
    * Sending alerts - /alarm
        * trigger the strobe for a short time
        * turn the status LED red
        * trigger an audible message
            * alarm sound once
            * "In store pixels are unstable" 
    * Re-Sending alerts - /alarm
        * trigger the strobe for a short time
        * turn the status LED red 
    * Sending Recovery message - /alarm
        * trigger the strobe for a short time
        * trigger audible message
            * play recover sound
            * "In store pixels have recovered"
        * turn the status LED blue
* __Deployments__ -
    * Doing a deployment - /deployment
        * trigger the strobe for a short time
        * "<first_name> <last_name> is deploying code to <service>"
        * once deployment completes
            * play mario bros sound
* __Verkundenbot Web App__ - /outlet/{id}/{desired-state}
    * Trigger outlet A from UI - /outlet/a
        * turn on outlet A
    * Trigger outlet B from UI - /outlet/b
        * turn on outlet B
    * Trigger outlet C from UI - /outlet/c
        * turn on outlet C
    * Message - /free-speach
        * play whatever message that's submitted
* __PagerDuty (future)__ - TDB

#### What does the swagger doc look like?



## IoT Device Software


mvn compile

mvn package 


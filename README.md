# Verkündenbot

---
## What is it and Why? 
In short, Verkündenbot is a set of individually programmable plugs. Yes you can purchase
programmable plugs on Amazon; in many case far cheaper than it costs to build this project. 

The purpose of this project is to create a physical device that enables exploration 
of prevalent technologies including Internet of Things (IoT) 
and Message Queuing Telemetry Transport (MQTT), while concurrently delving into 
various AWS Cloud Services such as AWS IoT, Lambda, S3, and DynamoDB.

WARNING: It is important to note that this project involves the development of a physical device capable of converting 
typical household electricity, operating at 120 volts and 20-30 amps. Due to the involvement of high voltage 
components, I do not recommend the handling of any aspects of the project related to the handling or configuration 
of said high voltage components. Extreme caution should be exercised when dealing with these components to 
ensure the safety and well-being of all individuals involved.

![Verkundenbot](https://github.com/highhair20/verkundenbot/blob/master/resources/vkb_large.jpg?raw=true)

## Before You Begin
This project uses Terraform with an S3 backend. If you are not already set up for an S3 backend 
you can follow the steps [here](https://github.com/highhair20/terraform-backend-s3).

## Getting Started
* [Setup the Device](device/README.md)
* [Setup the IoT Infrastructure](iot/README.md)

--- 

## Technologies

#### AWS
* AWS Cloud Services
  * AWS IoT
  * AWS Lambda ?
  
* Software
  * ?

#### Device
* Hardware
  * RaspberryPi 2 Model B 
  * RELAYplate from [Pi Plates](https://pi-plates.com/product/relayplate/)
  * Laser cut acrylic pieces from [Ponoko](https://www.ponoko.com/)
* Software
  * RaspbianOS v?
  * Python v?

IoT
* Terraform

#### WebApp
* ReactJS
* Ant
* Yarn
* AWS S3
* AWS CloudFront

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


# Verkündenbot Device

---

The Verkündenbot device is an AWS IoT enabled physical device consisting of a set of 
individually programmable plugs locally controlled by a RaspberryPi.
The Message Queuing Telemetry Transport (MQTT) protocol determines 
the state of the device.

## Device
For the purposes of this project I used a RaspberryPi 2 I had lying around.
I set it up as a headless RaspberryPi.

1. Follow [these](https://gist.github.com/highhair20/a0096e6bc70f796af7cf5a912fa44aef) instructions
to set up a headless RaspberryPi
2. SSH into the RaspberryPi and get the latest git checkout:
```
sudo git clone https://github.com/highhair20/verkundenbot.git /opt/glolabs/verkundenbot
```
3. Install the Verkündenbot software as a service. This will guarantee the application
   restarts when the device is plugged in.
```
bash /opt/glolabs/verkundenbot/device/scripts/install.sh
```

# ToDo
* Terraform the [RaspberryPi](https://github.com/clayshek/terraform-raspberrypi-bootstrap/blob/master/main.tf)

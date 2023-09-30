# Verkündenbot Device

The Verkündenbot Device is an AWS IoT enabled device.
The messages determine the state of the physical device.

## Device
For the purposes of this project I used a RaspberryPi 2 I had lying around.

1. Follow [these](https://gist.github.com/highhair20/a0096e6bc70f796af7cf5a912fa44aef) directions to set up a headless RaspberryPi
2. SSH into the RaspberryPi and get the latest git checkout:
```
sudo git clone https://github.com/highhair20/verkundenbot.git /opt/verkundenbot
```
3. Install the Verkündenbot software as a service. This will guarantee the application
   restarts when the device is plugged in.
```
bash /opt/verkundenbot/device/scripts/install.sh
```




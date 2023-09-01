#!/bin/bash

# Update the system
sudo apt update
sudo apt upgrade -y
sudo apt autoremove

# Discard any unneeded files that have been downloaded as part of the upgrade.
sudo apt clean

# Set the app to run on reboot
ln -s /opt/glolabs/verkundenbot/device/system/verkundenbot.service /etc/systemd/system/verkundenbot.service
sudo systemctl start /opt/glolabs/verkundenbot/device/app/verkundenbot.py    # Runs the script now
sudo systemctl enable /opt/glolabs/verkundenbot/device/app/verkundenbot.py   # Sets the script to run every boot

# copy certs from s3

# Finish by restarting:
sudo reboot

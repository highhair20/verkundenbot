#!/bin/bash

# Update the system
sudo apt update
sudo apt upgrade -y
sudo apt autoremove

# Discard any unneeded files that have been downloaded as part of the upgrade.
sudo apt clean

# Set the app to run on reboot
ln -s
sudo systemctl start /opt/glolabs/verkundenbot/device/app/healthcheck.py    # Runs the script now
sudo systemctl enable /opt/glolabs/verkundenbot/device/app/healthcheck.py   # Sets the script to run every boot

# Finish by restarting:
sudo reboot

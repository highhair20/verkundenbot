#!/bin/bash

# Make sure that we can ssh into the Raspberry Pi. In order to do so the
# /boot/ssh file just exist with the proper permissions.
sudo -i
cd /boot
touch ssh
chown root:root ssh
chmod 755 ssh
shutdown -r now

# Update the system
sudo apt update
sudo apt upgrade -y
sudo apt autoremove

# Discard any unneeded files that have been downloaded as part of the upgrade.
sudo apt clean

# Finish by restarting:
sudo reboot

# Install dependencies (if required)
# sudo apt install -y <dependency_packages>


# Set the app to run on reboot

sudo systemctl start /opt/verkundenbot/device/app.py    # Runs the script now
sudo systemctl enable /opt/verkundenbot/device/app.py   # Sets the script to run every boot



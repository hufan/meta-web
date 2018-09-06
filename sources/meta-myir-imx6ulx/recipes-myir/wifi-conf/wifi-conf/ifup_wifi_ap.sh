#/bin/sh

ifconfig wlan0 up 192.168.5.1
sleep 1
udhcpd /etc/udhcpd.conf &
sleep 1
hostapd -B /etc/hostapd.conf


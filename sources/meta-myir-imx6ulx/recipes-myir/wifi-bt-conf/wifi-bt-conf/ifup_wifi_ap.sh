#/bin/sh

ifconfig wlan0 up 192.168.10.1
sleep 1
udhcpd /etc/wifi-conf/udhcpd.conf &
sleep 1
hostapd -B /etc/wifi-conf/hostapd.conf


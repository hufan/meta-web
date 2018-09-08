#!/bin/bash

RFKILL_SYSFS_PTAH="/sys/class/rfkill"
RFKILL_T="rfkill"
T_HCI="hci0"
T_WIFI="phy0"

for i in $(seq 0 4)
do 
	PATH_TEMP=${RFKILL_SYSFS_PTAH}"/"${RFKILL_T}${i}
	if [ -d $PATH_TEMP ]; then
		temp_name=` cat ${RFKILL_SYSFS_PTAH}"/"${RFKILL_T}${i}"/name" `
		#echo ${temp_name}
		if [ $T_HCI != ${temp_name} ]; then
			hciattach /dev/ttymxc2 any 115200 -t120 flow
			# sleep 3
			#echo 1 >  ${PATH_TEMP}"/state"
		fi 
	fi
done

kill_wpa_fun(){
  PRO_NAME="wpa_supplicant"
  NUM=` ps aux | grep -w ${PRO_NAME} | grep -v grep |wc -l `
  if [ $NUM -gt 0 ]
  then
  	killall wpa_supplicant
  fi
}


kill_wpa_fun
if [ -d $RFKILL_SYSFS_PTAH ]; then
	# echo " enable wifi & bt control"
	for i in $(seq 0 4)
	do 
		# echo $(expr $i \* 3 + 1);
		PATH_TEMP=${RFKILL_SYSFS_PTAH}"/"${RFKILL_T}${i}
		if [ -d $PATH_TEMP ]; then
			temp_name=` cat ${RFKILL_SYSFS_PTAH}"/"${RFKILL_T}${i}"/name" `
			#echo ${temp_name}
			if [ $T_WIFI == ${temp_name} ]; then
				echo 1 >  ${PATH_TEMP}"/state"
			elif [ $T_HCI == ${temp_name} ]; then
				echo 1 >  ${PATH_TEMP}"/state"
			else
				echo "empty"
			fi 
		fi
	done
fi
kill_wpa_fun

#/bin/sh

RFKILL_SYSFS_PTAH="/sys/class/rfkill"
RFKILL_T="rfkill"
T_HCI="hci0"

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

#kill -9 ` ps -A | grep "wpa_supplicant"| awk '{print $1}' `
killall wpa_supplicant
if [ -d $RFKILL_SYSFS_PTAH ]; then
	# echo " enable wifi & bt control"
	for i in $(seq 0 4)
	do 
		# echo $(expr $i \* 3 + 1);
		PATH_TEMP=${RFKILL_SYSFS_PTAH}"/"${RFKILL_T}${i}
		if [ -d $PATH_TEMP ]; then
			temp_name=` cat ${RFKILL_SYSFS_PTAH}"/"${RFKILL_T}${i}"/name" `
			#echo ${temp_name}
			if [ "phy0" == ${temp_name} ]; then
				echo 1 >  ${PATH_TEMP}"/state"
			elif [ "hci0" == ${temp_name} ]; then
				echo 1 >  ${PATH_TEMP}"/state"
			else
				echo "empty"
			fi 
		fi
	done
fi
killall wpa_supplicant

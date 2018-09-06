# Copyright (C) 2012 O.S. Systems Software LTDA.

DESCRIPTION = "Extra files for MYiR"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=309cc7bace8769cfabdd34577f654f8e"

SRC_URI = "file://hostapd.conf \
		   file://udhcpd.conf \
           file://ifup_wifi_ap.sh \
           file://enable-wifi-bt.sh \
           file://LICENSE \
           "
		   
S = "${WORKDIR}"

do_install () {
    install -d ${D}/${sysconfdir}/init.d
	install -d ${D}/${sysconfdir}/wifi-conf
    
	install -m 755 ${S}/hostapd.conf  ${D}/${sysconfdir}/wifi-conf/
    install -m 755 ${S}/udhcpd.conf  ${D}/${sysconfdir}/wifi-conf/
	
    install -m 755 ${S}/enable-wifi-bt.sh  ${D}/${sysconfdir}/wifi-conf/
	install -m 755 ${S}/ifup_wifi_ap.sh  ${D}/${sysconfdir}/wifi-conf/
}

FILES_${PN} = " ${sysconfdir}/ \
				${sysconfdir}/wifi-conf \
			  "


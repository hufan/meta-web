SUMMARY = "bcmd43438A firmware"
LICENSE = "GPLv2"
PV = "0.1"
LIC_FILES_CHKSUM = "file://LICENCE;md5=309cc7bace8769cfabdd34577f654f8e"

SRC_URI = " \
    file://fw_bcm43436b0.bin \
    file://fw_bcm43436b0_apsta.bin \
    file://fw_bcm43438a0.bin \
    file://fw_bcm43438a0_apsta.bin \
    file://fw_bcm43438a0_p2p.bin \
    file://fw_bcm43438a1.bin \
    file://fw_bcm43438a1_apsta.bin \
    file://fw_bcm43438a1_p2p.bin \
    file://nvram_ap6212.txt \
    file://nvram_ap6212a.txt \
    file://nvram_ap6236.txt \	
    file://BCM4343B0.hcd \
    file://bcm43438a0.hcd \	
    file://bcm43438a1.hcd \	
    file://LICENCE \
"

S = "${WORKDIR}"

do_install (){
    	install -d ${D}${base_libdir}/firmware/bcmd
    
	cp -rfv fw_bcm43436b0.bin ${D}${base_libdir}/firmware/bcmd/
	cp -rfv fw_bcm43436b0_apsta.bin  ${D}${base_libdir}/firmware/bcmd/
	
	cp -rfv fw_bcm43438a0.bin ${D}${base_libdir}/firmware/bcmd/
	cp -rfv fw_bcm43438a0_apsta.bin ${D}${base_libdir}/firmware/bcmd/
	
	cp -rfv fw_bcm43438a0_p2p.bin ${D}${base_libdir}/firmware/bcmd/
	cp -rfv fw_bcm43438a1.bin ${D}${base_libdir}/firmware/bcmd/
	cp -rfv fw_bcm43438a1_apsta.bin ${D}${base_libdir}/firmware/bcmd/
	cp -rfv fw_bcm43438a1_p2p.bin ${D}${base_libdir}/firmware/bcmd/
	
	cp -rfv nvram_ap6212.txt ${D}${base_libdir}/firmware/bcmd/
	cp -rfv nvram_ap6212a.txt ${D}${base_libdir}/firmware/bcmd/
	cp -rfv nvram_ap6236.txt ${D}${base_libdir}/firmware/bcmd/
	
        cp -rfv  BCM4343B0.hcd  ${D}${base_libdir}/firmware/bcmd/
	cp -rfv  bcm43438a0.hcd  ${D}${base_libdir}/firmware/bcmd/
	cp -rfv  bcm43438a1.hcd  ${D}${base_libdir}/firmware/bcmd/
}

FILES_${PN} = "${base_libdir}/firmware/bcmd \
"

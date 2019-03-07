SUMMARY = "wifi driver for RTL8188EU on MYS6ULx board"
LICENSE = "GPLv2"
PV = "0.1"
LIC_FILES_CHKSUM = "file://ifcfg-wlan0;md5=a84acae65af4b2d44d5035aa9f63cd85"


inherit module

SRCREV = "88035cf8b8e4023f48a86e29b9ed84c45775fe72"
SRC_URI = "git://github.com/MYiR-Dev/RTL8188EUS;protocol=https;branch=master"
S = "${WORKDIR}/git"
FILES_${PN} = "${base_libdir}/firmware/rtlwifi"

do_install_append() {
    install -d ${D}${base_libdir}/firmware/rtlwifi
}

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

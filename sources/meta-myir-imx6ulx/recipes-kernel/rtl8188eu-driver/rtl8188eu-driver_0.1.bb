SUMMARY = "wifi driver for RTL8188EU on MYS6ULx board"
LICENSE = "GPLv2"
PV = "0.1"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRCREV = "77590caff84c93390fc63a1cd9b412be1a4197ef"
SRC_URI = "git://github.com/MYiR-Dev/RTL8188EUS.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

inherit module

do_install_append() {
    install -d ${D}${base_libdir}/firmware/rtlwifi
}

FILES_${PN} += " \
    ${base_libdir}/firmware \
    ${base_libdir}/firmware/rtlwifi \
    ${base_libdir}/firmware/rtlwifi/rtl8188eufw.bin \
"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
COMPATIBLE_MACHINE = "(odm-sds)"

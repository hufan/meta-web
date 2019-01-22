# Copyright (C) 2013-2016 Freescale Semiconductor

DESCRIPTION = "U-Boot provided by Freescale && MYiR focus on MYS6ULx board."
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRCBRANCH = "myd-y6ulx-hmi"
UBOOT_SRC = "git:////${HOME}/MYiR-iMX-Uboot;protocol=file"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "4b094406a0c17db99552ed3631000b9bfd8fee65"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|mx6ull|mx7)"

# Copyright (C) 2013-2016 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for MYiR MYS6ULx board"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

LOCALVERSION = "-1.2.0"
SRCREV = "e36223d68e5eef88ac91abd71cbaf2ff366626c5"
SRCBRANCH = "myd-y6ulx-hmi"
SRC_URI = "git:///${HOME}/MYiR-iMX-Linux;protocol=file;branch=${SRCBRANCH} \
           file://defconfig \ 
        "

DEFAULT_PREFERENCE = "1"

COMPATIBLE_MACHINE = "(mx6ull|mx6ul)"

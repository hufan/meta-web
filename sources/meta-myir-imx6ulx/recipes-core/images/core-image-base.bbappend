IMAGE_INSTALL += "imx-kobs \
    net-tools \
    ethtool \
    evtest \
    iputils \
    udev-extraconf \
    rpm \
    openssh \
    openssl \
    ${@base_contains("MACHINE", "mys6ull14x14", "rtl8188eu-driver", "", d)} \
    vsftpd \
    parted \
    u-boot-fw-utils \
    mmc-utils \
    util-linux-sfdisk \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    mtd-utils-ubifs \
    wifi-bt-conf \
    myir-rc-local"

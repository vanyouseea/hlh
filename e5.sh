#!/usr/bin/env bash
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH

# this script is called by cron job to renew the microsoft e5 automatically
# Need to upload file named like 0.jpg~9.jpg to onedrive
#

curl hlhhrl.tk/od
filename=`echo $(($RANDOM%10))`

cd /root/
wget "hlhhrl.tk/od/?/${filename}.jpg" -O /root/download/${filename}.jpg

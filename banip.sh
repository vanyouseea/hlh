#!/usr/bin/env bash
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH

BanIPPath=banIPs
PORT=2222

#
# this script is using lastb to get top 500 failed authentication IP and ban them or port
# All the firewall script will be written in ~/banIPs/rejectIPs.sh
# if port is empty, script will ban IP, else ban port
# After running this script, you can view the rejectIPs.sh to check it is correct or not
# if ok, run it to ban the IP or port, then delete rejectIPs.sh manaully
# 

mkdir -p ~/$BanIPPath/
cd ~/$BanIPPath/

#get the top 500 IPs and discnt them
lastb|head -500|awk -F' ' '{print $3}'|sort -n|grep ^[0-9]|uniq > ips.txt

while read line
do
	iptables -nL|grep $line > /dev/null 2>&1 
	if [ $? -ne 0 ]
	then
		if [ "$PORT" = "" ]
		then
			#if no port defined ban IP
			echo "echo ban the ip $line" >>~/$BanIPPath/rejectIPs.sh
			echo "iptables -A INPUT -ptcp -s $line -j DROP;" >>rejectIPs.sh
		else
			#if there is port defined ban IP & port
			echo "echo ban the ip $line to access our port: $PORT" >>rejectIPs.sh
			echo "iptables -A INPUT -s $line -ptcp --dport $PORT -j DROP;" >>rejectIPs.sh
		fi
	fi
done<ips.txt

if [ -f rejectIPs.sh ]
then
	chmod 755 rejectIPs.sh
fi

rm ips.txt

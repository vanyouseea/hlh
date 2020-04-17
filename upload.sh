#!/bin/sh
# Once Aria download completed the will pass 3 args to the sh
# $1 is gid like 13ef4a9de9f3ef23
# $2 is downloaded file count
# $3 is random downloaded file name
#

downloadPath=/root/download

echo "==============================================================">> ~/res.txt
echo "[`date +%y-%m-%d` `date +%H:%M:%S`] Task $1:$2:$3 finished.">> ~/res.txt

if [ "$3" != "" -a $2 -ne 0 ]
then
	files=`echo "$3"|awk -F'/' '{print $4}'`

	realPath=$downloadPath/"$files"
	echo "[`date +%y-%m-%d` `date +%H:%M:%S`] Start to move "$realPath" to OneDrive.">> ~/res.txt

	#whether mount the onedrive or not, this is the best way to move
	if [ -f "$realPath" ]
	then
		rclone move "$realPath" hqr:vps >>~/res.txt 2>&1
	elif [ -d "$realPath" ]
	then
		rclone moveto "$realPath" hqr:vps/"$files" >>~/res.txt 2>&1
	else
		echo "[`date +%y-%m-%d` `date +%H:%M:%S`] Invalid file type">>~/res.txt
		exit 0	
	fi
	
	if [ $? -eq 0 ]
	then
		echo "[`date +%y-%m-%d` `date +%H:%M:%S`] Move "$realPath" to OneDrive successfully~">> ~/res.txt
		rm -rf "$realPath"
	else
		echo "[`date +%y-%m-%d` `date +%H:%M:%S`] Move "$realPath" to OneDrive unsuccessfully!">> ~/res.txt
	fi
fi
echo " ">> ~/res.txt

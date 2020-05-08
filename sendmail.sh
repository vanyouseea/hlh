#!/bin/sh

#
# $1 is Subject, subject less than 20 chars can be shown fully in phone
# You can put the message in $1 and integrated with China Mobile 139 mail
# When you send the email to 139, you will received SMS notification
#

cd ~/mail

json1='{"message": {"subject": "'
json2='","body": {"contentType": "Text","content": "Attention!"},"toRecipients": [{"emailAddress": {"address": "138202313230@139.com"}}]}}'

#get accessToken
echo "1.start to get accessToken"
accessToken=`curl -s -XPOST -H 'Content-Type: application/x-www-form-urlencoded' -T body.txt 'https://login.microsoftonline.com/common/oauth2/v2.0/token'|awk -F',' '{print $5}'|awk -F'"' '{print $4}'`
echo "1.accessToken got "$accessToken

#replace the message with the template.txt
if [ -z "$1" ]
then
	#use EventIsReady template send email
	echo ${json1}EventIsReady${json2} >temp.json
	echo "2.start to send default event:EventIsReady"
	curl -XPOST -H "Authorization: Bearer $accessToken" -H "Content-type: application/json" -T temp.json 'https://graph.microsoft.com/v1.0/me/sendMail'
	echo "2.end to send default event:EventIsReady"
else
	#format the template and send email
	echo ${json1}${1}${json2} >temp.json
	echo "2.start to send event:"$1
	curl -XPOST -H "Authorization: Bearer $accessToken" -H "Content-type: application/json" -T temp.json 'https://graph.microsoft.com/v1.0/me/sendMail'
	echo "2.end to send event:"$1
fi

#rm temp.json

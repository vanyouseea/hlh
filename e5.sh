#!/usr/bin/env bash
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH

# this script is called by cron job to renew the microsoft e5 automatically

#get accessToken
echo "1.start to get accessToken"
accessToken=`curl -s -XPOST -H 'Content-Type: application/x-www-form-urlencoded' -T ~/body.txt 'https://login.microsoftonline.com/common/oauth2/v2.0/token'|awk -F',' '{print $5}'|awk -F'"' '{print $4}'`
echo "1.accessToken got "$accessToken

#use the token to get the email subject and count all of emails
echo "2.start to get email subject"
curl -XGET -H "Authorization: Bearer $accessToken" 'https://graph.microsoft.com/v1.0/me/messages?$select=subject&$count=true'
echo "2.end to get email subject"

#get drive id
echo "3.start to get driveId"
driveId=`curl -s -XGET -H "Authorization: Bearer $accessToken" 'https://graph.microsoft.com/v1.0/me/drive?$select=id'|awk -F',' '{print $2}'|awk -F'"' '{print $4}'`
echo "3.driveId is"$driveId

#get top 5 items in vps folder and only get their name item
echo "4.start to get top 5 items in vps folder"
curl -XGET -H "Authorization: Bearer $accessToken" 'https://graph.microsoft.com/v1.0/me/drive/root:/vps:/children?$top=5&$select=name'
echo "4.end to get top 5 items in vps folder"

#search items - be careful with the escape character
echo "5.start to search keyword ap-700"
curl -XGET -H "Authorization: Bearer $accessToken" 'https://graph.microsoft.com/v1.0/me/drive/root/search(q='\'ap-700\'')?$select=id,name,size,file'
echo "5.end to search keyword ap-700"

#This url is to upload file 
#curl -XPUT -H "Authorization: Bearer $accessToken" -T body.txt 'https://graph.microsoft.com/v1.0/me/drive/root:/body.txt:/content'
#upload file body.txt to / and get the item id
echo "6.start to upload file body.txt to od"
itemId=`curl -s -XPUT -H "Authorization: Bearer $accessToken" -T ~/body.txt 'https://graph.microsoft.com/v1.0/me/drive/root:/body.txt:/content'|awk -F',' '{print $6}'|awk -F'"' '{print $4}'`
echo "6.end to upload, the itemId is "$itemId

#get item info by itemId
echo "7.1 start to get the item info by itemId"
curl -XGET -H "Authorization: Bearer $accessToken" "https://graph.microsoft.com/v1.0/me/drive/items/$itemId"
echo "7.1 end to get the item info by itemId"

#get item info by driveId and itemId
echo "7.2 start to get the item info by itemId"
curl -XGET -H "Authorization: Bearer $accessToken" "https://graph.microsoft.com/v1.0/me/drives/$driveId/items/$itemId"
echo "7.2 end to get the item info by itemId"

#delete file body.txt from /
echo "8.start to delete the file body.txt"
curl -XDELETE -H "Authorization: Bearer $accessToken" "https://graph.microsoft.com/v1.0/me/drive/items/$itemId"
echo "8.end to delete the file body.txt"

#!/bin/bash
sed -i 's/java-11/java-8/g' /etc/environment
source /etc/environment

wget --directory-prefix=/tmp/ https://www.datasciencebytes.com/data/nationalparks.csv

mkdir /root/project
mkdir /root/project/src
mkdir /root/project/src/main
mkdir /root/project/src/main/java
mkdir /root/project/src/main/resources

cp /tmp/pom.xml /root/project/pom.xml
cp /tmp/SparkAppMain.java /root/project/src/main/java/SparkAppMain.java
cp /tmp/spline.properties /root/project/src/main/resources/spline.properties

sed -i 's,###,https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/producer,g' /root/project/src/main/resources/spline.properties
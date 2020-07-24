#!/bin/bash
sed -i 's/java-11/java-8/g' /etc/environment
source /etc/environment

wget --directory-prefix=/tmp/ https://www.datasciencebytes.com/data/nationalparks.csv

mkdir project
mkdir project/src
mkdir project/src/main
mkdir project/src/main/java
mkdir project/src/main/resources

mv /tmp/pom.xml project/pom.xml
mv /tmp/SparkAppMain.java project/src/main/java/SparkAppMain.java
mv /tmp/spline.properties project/src/main/resources/spline.properties

sed -i 's,###,https://[[HOST_SUBDOMAIN]]-8080-[[KATACODA_HOST]].environments.katacoda.com/producer,g' project/src/main/resources/spline.properties
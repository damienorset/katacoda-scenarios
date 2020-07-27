#!/bin/bash
sed -i 's/java-11/java-8/g' /etc/environment
source /etc/environment

wget --directory-prefix=/tmp/ https://www.datasciencebytes.com/data/nationalparks.csv

mkdir project
mkdir project/src
mkdir project/src/main
mkdir project/src/main/java
mkdir project/src/main/resources

cp /tmp/pom.xml project/pom.xml
cp /tmp/SparkAppMain.java project/src/main/java/SparkAppMain.java
cp /tmp/spline.properties project/src/main/resources/spline.properties

sed -i 's,###,https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/producer,g' project/src/main/resources/spline.properties
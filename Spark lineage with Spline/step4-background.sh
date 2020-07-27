#!/bin/bash

mkdir /root/project2
mkdir /root/project2/src
mkdir /root/project2/src/main
mkdir /root/project2/src/main/java
mkdir /root/project2/src/main/resources

cp /tmp/pom.xml /root/project2/pom.xml
cp /tmp/SparkApp2Main.java /root/project2/src/main/java/SparkApp2Main.java
cp /tmp/spline.properties /root/project2/src/main/resources/spline.properties

sed -i 's,###,https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/producer,g' /root/project2/src/main/resources/spline.properties
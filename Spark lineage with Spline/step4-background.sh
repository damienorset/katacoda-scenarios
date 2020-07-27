#!/bin/bash

mkdir project2
mkdir project2/src
mkdir project2/src/main
mkdir project2/src/main/java
mkdir project2/src/main/resources

cp /tmp/pom.xml project/pom.xml
cp /tmp/SparkApp2Main.java project/src/main/java/SparkApp2Main.java
cp /tmp/spline.properties project/src/main/resources/spline.properties

sed -i 's,###,https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/producer,g' project/src/main/resources/spline.properties
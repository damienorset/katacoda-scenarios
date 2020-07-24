We'll now create a sample spark job in java.

In a new terminal tab

1. Setup the correct JAVA_HOME
`sed -i 's/java-11/java-8/g' /etc/environment`{{execute T2}}

`source /etc/environment`{{execute T2}}

2. Install Spark
`wget http://apache.crihan.fr/dist/spark/spark-2.4.6/spark-2.4.6-bin-hadoop2.6.tgz`{{execute T2}}

`tar xzf spark-2.4.6-bin-hadoop2.6.tgz`{{execute T2}}

3. Verify the java project structure





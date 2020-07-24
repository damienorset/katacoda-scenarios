We'll now create a sample spark job in java.

In a new terminal tab

1. Setup the correct JAVA_HOME
`sed -i 's/java-11/java-8/g' /etc/environment`{{execute}}

`source /etc/environment`{{execute}}

2. Install Spark
`wget http://apache.crihan.fr/dist/spark/spark-2.4.6/spark-2.4.6-bin-hadoop2.6.tgz`{{execute}}

`tar xzf spark-2.4.6-bin-hadoop2.6.tgz`{{execute}}

3. Create the java project structure

`mkdir project && mkdir project/src && mkdir project/src/main && mkdir project/src/main/java && mkdir project/src/main/resources && cd project`{{execute}}resources

create empty file

`touch pom.xml && touch src/main/java/SparkAppMain.java $$ touch src/main/resources/spline.properties`{{execute}}resources



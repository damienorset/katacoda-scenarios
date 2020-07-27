This job will get the input from /tmp/nationalparks.csv file, then makes 3 outputs :
- nationalparks_copy.csv : a simple copy of the input file
- utah_parks.csv : contains only the parks in Utah (filter)
- agg_parks.csv : Agregation of the park aera by state 

1. launch the spark job `./spark-2.4.6-bin-hadoop2.6/bin/spark-submit --master local[*] --class SparkAppMain project/target/spark-testjob-1.0-SNAPSHOT-jar-with-dependencies.jar`{{execute T3}}
2. See the different outputs of the job 
   1. `cat /root/project/nationalparks_copy.csv/*.csv`{{execute T3}}
   2. `cat /root/project/utah_parks.csv/*.csv`{{execute T3}}
   3. `cat /root/project/agg_parks.csv/*.csv`{{execute T3}}
3. Go to spline UI to see lineage : https://[[HOST_SUBDOMAIN]]-8080-[[KATACODA_HOST]].environments.katacoda.com/
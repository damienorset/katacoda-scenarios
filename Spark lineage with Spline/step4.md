Another spark job is created to produce new files derived from the previous ones :
- nationalparks_copy.csv : a copy form the previous copy
- agg_parks_utah.csv : hte agregation of the areas from all parks extracted in the previous step

1. Build the new job `cd /root/project2 && mvn clean install && cd /root`
2. launch the spark job `./spark-2.4.6-bin-hadoop2.6/bin/spark-submit --master local[*] --class SparkApp2Main project2/target/spark-testjob-1.0-SNAPSHOT-jar-with-dependencies.jar`{{execute T4}}
3. See the different outputs of the job 
   1. `cat /root/project2/nationalparks_copy2.csv/*.csv`{{execute T4}}
   2. `cat /root/project2/agg_parks_utah.csv/*.csv`{{execute T4}}
4. Go to spline UI to see lineage : https://[[HOST_SUBDOMAIN]]-8080-[[KATACODA_HOST]].environments.katacoda.com/

See for instance that "nationalparks_copy2.csv" is linked with "nationalparks_copy.csv" and "nationalparks.csv" through respectively "Job2" and "Job1"
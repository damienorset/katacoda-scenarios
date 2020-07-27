Another spark job is created to produce new files derived from the previous ones :
- nationalparks_copy.csv : a copy form the previous copy
- agg_parks_utah.csv : hte agregation of the areas from all parks extracted in the previous step

1. launch the spark job `./spark-2.4.6-bin-hadoop2.6/bin/spark-submit --master local[*] --class SparkApp2Main project2/target/spark-testjob-1.0-SNAPSHOT-jar-with-dependencies.jar`{{execute T4}}
2. See the different outputs of the job 
   1. `cat /root/project/nationalparks_copy.csv/*.csv`{{execute T4}}
   2. `cat /root/project/agg_parks_utah.csv/*.csv`{{execute T4}}
3. Go to spline UI to see lineage : https://[[HOST_SUBDOMAIN]]-8080-[[KATACODA_HOST]].environments.katacoda.com/
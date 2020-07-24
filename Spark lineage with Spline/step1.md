We'll start a spline server, with arrangoDB as the storage backend and the spline UI.

1. Get the docker-compose file for an easy setup of spline
`wget https://raw.githubusercontent.com/AbsaOSS/spline/release/0.5/docker-compose.yml`{{execute T1}}

2. Change the spline.consumer.url
+ Manually by putting `https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/`{{copy}} in the docker-compose file
+ Or automatically `sed -i "s,spline.consumer.url: 'http://localhost:9090/consumer',spline.consumer.url: 'https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/consumer',g" docker-compose.yml`{{execute T1}}

1. Start spline container with `docker-compose up`{{execute T1}}
It takes 1 minute.
Verify that the product is well launch by going on the following url : https://[[HOST_SUBDOMAIN]]-8080-[[KATACODA_HOST]].environments.katacoda.com/
+ If there's an error Ctrl+C and `docker-compose down`{{execute T1}} to stop and remove all the containers 
+ Then start service by service :
  + `docker-compose up -d arangodb`{{execute T1}}
  + `docker-compose up -d spline`{{execute T1}}
  + `docker-compose up -d ui`{{execute T1}}
+ And verify in https://[[HOST_SUBDOMAIN]]-8080-[[KATACODA_HOST]].environments.katacoda.com/

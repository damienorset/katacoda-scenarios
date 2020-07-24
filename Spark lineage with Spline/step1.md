1. Get the docker-compose file for an easy set of spline
`wget https://raw.githubusercontent.com/AbsaOSS/spline/release/0.5/docker-compose.yml`{{execute}}

2. Change the spline.consumer.url

+ Manually by putting https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/ in the docker-compose file

+ Or automatically `sed -i "s,spline.consumer.url: 'http://localhost:9090/consumer',spline.consumer.url: 'https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/',g" docker-compose.yml`{{execute}}

3. Start spline container
`docker-compose up`{{execute}}
Verify that the product is well launch by going on the following url : https://[[HOST_SUBDOMAIN]]-8080-[[KATACODA_HOST]].environments.katacoda.com/

If there's an error Ctrl+C to stop the containers and `docker-compose up`{{execute}} to relaunch the stack.

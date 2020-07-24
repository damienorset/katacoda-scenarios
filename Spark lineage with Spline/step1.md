+ Get the docker-compose file for an easy set of spline
`wget https://raw.githubusercontent.com/AbsaOSS/spline/release/0.5/docker-compose.yml`{{execute}}

+ Change the spline.consumer.url

1. Manually by putting https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/ in the docker-compose file

2. Or automatically `sed -i "s/spline.consumer.url: 'http://localhost:9090/consumer'/spline.consumer.url: 'https://[[HOST_SUBDOMAIN]]-9090-[[KATACODA_HOST]].environments.katacoda.com/'/g" docker-compose.yml`{{execute}}

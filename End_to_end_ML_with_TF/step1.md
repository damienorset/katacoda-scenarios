Cloner le repo Google 
`git clone https://github.com/GoogleCloudPlatform/training-data-analyst.git`{{execute}}

Installer Python3
`apt -y install python3-pip`{{execute}}

Installer les différents packages python nécéssaires
`pip3 install jupyter pandas datalab`{{execute}}

Configurer Jupyter et lui créer un mdp
`jupyter notebook --generate-config`{{execute}}
`jupyter notebook password`{{execute}}

Lancer Jupyter
`jupyter notebook --allow-root --ip 0.0.0.0`{{execute}}

Ouvrir le Jupyter hub
https://[[HOST_SUBDOMAIN]]-8888-[[KATACODA_HOST]].environments.katacoda.com/


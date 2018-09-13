1. Installer Python3
`apt -y install python3-pip`{{execute}}

2. Installer les différents packages python nécéssaires
`pip3 install jupyter pandas datalab`{{execute}}

3. Cloner le repo Google 
`git clone https://github.com/GoogleCloudPlatform/training-data-analyst.git`{{execute}}

4. Configurer Jupyter et lui créer un mdp
+ `jupyter notebook --generate-config`{{execute}}
+ `jupyter notebook password`{{execute}} ou `sed -i "s/#c.NotebookApp.password = ''/c.NotebookApp.password = u'sha1:6c2164fc2b22:ed55ecf07fc0f985ab46561483c0e888e8964ae6'/g"  /root/.jupyter/jupyter_notebook_config.py`{{execute}} pour mettre le password par défaut "secret"

5. Lancer Jupyter
`jupyter notebook --allow-root --ip 0.0.0.0 --no-browser`{{execute}}

6. Ouvrir le Jupyter hub
https://[[HOST_SUBDOMAIN]]-8888-[[KATACODA_HOST]].environments.katacoda.com/


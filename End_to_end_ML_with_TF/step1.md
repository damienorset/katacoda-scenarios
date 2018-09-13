+ Installer Python3
`apt -y install python3-pip`{{execute}}

+ Installer les différents packages python nécéssaires
`pip3 install jupyter pandas datalab`{{execute}}

+ Cloner le repo Google 
`git clone https://github.com/GoogleCloudPlatform/training-data-analyst.git`{{execute}}

+ Configurer Jupyter et lui créer un mdp
1. `jupyter notebook --generate-config`{{execute}}
2. `jupyter notebook password`{{execute}} ou `sed -i "s/#c.NotebookApp.password = ''/c.NotebookApp.password = u'sha1:6c2164fc2b22:ed55ecf07fc0f985ab46561483c0e888e8964ae6'/g"  /root/.jupyter/jupyter_notebook_config.py`{{execute}} pour mettre le password par défaut "secret"


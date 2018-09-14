+ Install Python3
`apt -y install python3-pip`{{execute}}

+ Install the required packages
`pip3 install jupyter pandas datalab tensorflow==1.5.0`{{execute}}

+ Configurate Jupyter and create a password
1. `jupyter notebook --generate-config`{{execute}}
2. `jupyter notebook password`{{execute}} or `sed -i "s/#c.NotebookApp.password = ''/c.NotebookApp.password = u'sha1:6c2164fc2b22:ed55ecf07fc0f985ab46561483c0e888e8964ae6'/g"  /root/.jupyter/jupyter_notebook_config.py`{{execute}} to put the default password "secret"

#/bin/bash

apt -y install python3-pip
pip3 install jupyter pandas datalab
jupyter notebook --generate-config
sed -i "s/#c.NotebookApp.password = ''/c.NotebookApp.password = u'sha1:6c2164fc2b22:ed55ecf07fc0f985ab46561483c0e888e8964ae6'/g" /root/.jupyter/jupyter_notebook_config.py 
git clone https://github.com/GoogleCloudPlatform/training-data-analyst.git
jupyter notebook --allow-root --ip 0.0.0.0 --no-browser &

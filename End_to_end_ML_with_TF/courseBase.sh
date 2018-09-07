#/bin/bash
touch /root/test.123
git clone https://github.com/GoogleCloudPlatform/training-data-analyst.git
cd training-data-analyst/courses/machine_learning/deepdive/06_structured
apt -y install python3-pip
pip3 install jupyter

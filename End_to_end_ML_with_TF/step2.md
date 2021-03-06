+ Create Google credentials
1. `mkdir /root/.config`{{execute}}
2. `mkdir /root/.config/gcloud`{{execute}}
3. `touch /root/.config/gcloud/config.json`{{execute}}

+ Open in the katacoda's graphic editor the /root/.config/gcloud/config.json file and click bellow on "Copy to editor"
<pre class="file" data-filename="config.json" data-target="replace">
{
  "type": "service_account",
  "project_id": "essential-vim-197213",
  "private_key_id": "ef4f9a7a85ad3aefd598aa8c38fc3c2810783a4b",
  "private_key": "",
  "client_email": "513618600916-compute@developer.gserviceaccount.com",
  "client_id": "118422223426889345013",
  "auth_uri": "https://accounts.google.com/o/oauth2/auth",
  "token_uri": "https://oauth2.googleapis.com/token",
  "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
  "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/513618600916-compute%40developer.gserviceaccount.com"
}
</pre>

+ Add this env var 
`export GOOGLE_APPLICATION_CREDENTIALS=/root/.config/gcloud/config.json`{{execute}}

+ Clone the training Google repo 
`git clone https://github.com/GoogleCloudPlatform/training-data-analyst.git`{{execute}}

+ Move into the right place in the repo
`cd training-data-analyst/courses/machine_learning/deepdive/`{{execute}}

+ Launch Jupyter
`jupyter notebook --allow-root --ip 0.0.0.0 --no-browser`{{execute}}

+ Open Jupyter hub
https://[[HOST_SUBDOMAIN]]-8888-[[KATACODA_HOST]].environments.katacoda.com/

Créer des crédentials Google
`mkdir /root/.config`{{execute}}
`mkdir /root/.config/gcloud`{{execute}}
`vi /root/.config/gcloud/config.json`{{execute}}

Ajouter la variable ci dessous dans une cellule jupyter
import os
os.environ["GOOGLE_APPLICATION_CREDENTIALS"]="/root/.config/gcloud/config.json"

#!/usr/bin/env bash

# Se compila el proyecto con el perfil docker
mvn clean package -Pdocker

# Se detienen y eliminan los contenedores existentes
sudo docker-compose stop
sudo docker-compose rm -f

#if [ "$(curl --silent 192.168.99.100:8761/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
#    #docker-compose up -d auth-service
#    docker-compose up -d edge-service
#    docker-compose up -d user-service
#fi

# Se inicia el servicio de registro y se espera a que esté listo
sudo docker-compose up -d discovery-service

while [ -z ${DISCOVERY_SERVICE_READY} ]; do
  echo "Iniciando el servicio de Registro..."
  if [ "$(curl --silent 159.203.69.187:8761/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      DISCOVERY_SERVICE_READY=true;
  fi
  sleep 2
done

# Se inician los demás servicios
sudo docker-compose up -d
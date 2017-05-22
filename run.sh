#!/usr/bin/env bash

# Se compila el proyecto con el perfil docker
sudo mvn clean package -Pdocker -DskipTests

# Se detienen y eliminan los contenedores existentes
docker-compose stop
docker-compose rm -f

#if [ "$(curl --silent 192.168.99.100:8761/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
#    #docker-compose up -d auth-service
#    docker-compose up -d edge-service
#    docker-compose up -d user-service
#fi

# Se inicia el servicio de registro y se espera a que esté listo
docker-compose up -d discovery-service

while [ -z ${DISCOVERY_SERVICE_READY} ]; do
  echo "Iniciando el servicio de Registro..."
  if [ "$(curl --silent 192.168.99.100:8761/health 2>&1 | grep -q '\"status\":\"UP\"'; echo $?)" = 0 ]; then
      DISCOVERY_SERVICE_READY=true;
  fi
  sleep 2
done

# Se inician los demás servicios
docker-compose up -d
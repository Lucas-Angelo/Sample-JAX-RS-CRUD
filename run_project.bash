#!/bin/bash

# Nome do projeto
PROJECT_NAME="Sample JAX-RS GET"

# Verifica se o Maven está instalado
if ! command -v mvn &> /dev/null
then
    echo "Maven não está instalado ou não está disponível no PATH."
    exit 1
fi

# Limpa o projeto, compila e empacota
echo "Iniciando o processo de build para o projeto: $PROJECT_NAME"
mvn clean package

# Verifica se o build foi bem-sucedido
if [ $? -eq 0 ]; then
  echo "Build concluído com sucesso."

  # Inicia o servidor TomEE e executa o projeto
  echo "Iniciando o TomEE e executando o projeto..."
  mvn tomee:run
else
  echo "Erro no build. O servidor não será iniciado."
  exit 1
fi

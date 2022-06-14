# Magalu Communication API

URLs do projeto:

- POST: /api/v1/schedules
- GET: /api/v1/schedules
- DELETE: /api/v1/schedules/{scheduleId}

Há uma pasta na raiz do projeto chamada "postman-collection" para validação dos recursos, 
com os parametros e o body já configurados para uma chamada local na porta 8080.

# OBSERVAÇÕES:

1 - O CAMPO "communicationType" SÓ ACEITA OS SEGUINTES VALORES:
- EMAIL, SMS, PUSH e WHATSAPP.

2 - O CAMPO "scheduleStatus", SERÁ RETORNADO COM O VALOR "PENDENTE", ATÉ QUE SEJA CONFIGURADA A API DE ENVIO DA NOTIFICAÇÃO.

3 - O BANCO DE DADOS POSTGRES FOI CONFIGURADO COM OS SEGUINTES VALORES:
- DATABASE: magalu
- SCHEMA: communication
- USER: postgres
- PASSWORD: postgres
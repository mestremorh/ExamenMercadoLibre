## ExamenMercadoLibre

Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar
contra los X-Men.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un
humano es mutante basándose en su secuencia de ADN.

** Nivel 1 **
*Programa (en cualquier lenguaje de programación) que cumpla con el método pedido por
Magneto.*

Este nivel se desarrollo en JAVA en su version 1.8, utilizando el Framework Spring Boot, en el cual se desarrollo lo correspondiente a los 3 niveles.

** Nivel 2 **

*Crear una API REST, hostear esa API en un cloud computing libre (Google App Engine,
Amazon AWS, etc), crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:
POST → /mutant/
{
“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un
403-Forbidden*

Para este nivel se realizo el API requerido utilizando los servicios de AWS, especificamente se utilizaron los siguientes servicios:

- Funciones Lambdas

- Api Gateway

El fuente de dicha funcion se encuentra en el presente repositorio en el carpeta /APIS

**Archivo:** ApiMUTANT.js

**Url del Servicio:** https://k9ptq6f0m2.execute-api.us-east-2.amazonaws.com/TestMeli/mutant

**Nivel 3 **

*Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
Solo 1 registro por ADN.
Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}*

En este nivel se implementó un Modelo de datos de  los ofrecidos en AWS, especificmente DynamoDB, para capturar la información requerida. 
además, se implementó un nuevo servicio como se especificaba.

Para el desarrollo de este nivel se utilizaron los siguientes servicios de AWS:

- Funciones Lambda
- API Gateway
- DynamoDB


El fuente de dicha funcion se encuentra en el presente repositorio en el carpeta /APIS

**Archivo:** ApiSTATS.js

**Url del Servicio:** https://buw42kog32.execute-api.us-east-2.amazonaws.com/TestMeli/stats

***Nota:***
**Para los niveles 2 y 3 el desarrollo de las APIS se hizo utilizando Javascript (node)**

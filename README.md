# EuroVision

<p align="justify">
El siguiente proyecto conta de un componente backend y frontend con el fin de atender los requerimientos dispuestos en la prueba técnica.
</p>

## Parte 1 - Historias de Usuario

### Frontend
<p align="justify">
Se implementa la solución para que satisfaga las siguientes historias de usuario:

- Display a home page on the root path ("/") with the message "Welcome to Eurovision Services" 

Nota: En la siguiente imagen, se encuentra el punto de acceso a la aplicación ("/") con el mensaje especificado

![Home](https://github.com/alexel200/eurovision/assets/25227784/e010ec0a-3efc-4eac-9aaf-84fbc8a798c6)


- Display a cities page on the path ("/cities") with a table paginable with the list of cities (id, name)

Nota: Se implementa en el menú un item Cities, que re dirige a la ruta indicada "/cities"
![Menu](https://github.com/alexel200/eurovision/assets/25227784/30637b71-1a45-4302-8b16-10200b0e5957)

Una vez el usuario es re dirigido, se puede apreciar el "id" y el "name", en una tabla de material con su respectiva
paginación
![Tabla de ciudades paginada](https://github.com/alexel200/eurovision/assets/25227784/30637b71-1a45-4302-8b16-10200b0e5957)
</p>

### Backend
<p align="justify">
Por lo tanto, la información que se viusaliza en a través del Frontend, proviene del endpoint http://localhost:8080/api/cities/queryByPage?size=10&page=0,
obligatorio por el contrato compartido. Para ello, se puede hacer uso de la herramienta SwaggerUi para interactuar directamente con este endpoint (http://localhost:8080/swagger-ui/index.html#/Cities/queryByPage)

![SwaggerUi api/cities/queryByPage](https://github.com/alexel200/eurovision/assets/25227784/2e16c14a-5ffc-463f-bfe0-da0e652011a9)
</p>

## Parte 2 - Ejercicio Adicional 
<p align="justify">
Para los ejercicios propuestos, mi selección fue el ejercicio B. Para ello, existe un endpoint /api/cities/permutations
![Permutations endpoint](https://github.com/alexel200/eurovision/assets/25227784/5e561246-4271-48cb-8ff1-9c477677ccf8)


A nivel de Front, se puede visualizar el resultado a traves del item "Permutable Cities" del menú
![Permutable Cities](https://github.com/alexel200/eurovision/assets/25227784/1423891c-b3e0-431f-8828-c275930fe9a3)

Una vez alli, se dispone un formulario para ingresar un número entre 5 y 7. Después de presionar el botón "send", 
se inicia el procesamiento de la información y después de un par de minutos, se visualizará en pantalla el nombre
de la ciudad con más coincidencias de palabras válidas.
![The most permutable city](https://github.com/alexel200/eurovision/assets/25227784/651990d8-61cc-4dd8-b5f4-dc90e7548403)
</p>

## Docker
El proyecto puede ser ejecutado a traves de dockers, basta con ingresar al directorio "docker", que se encuentra en 
la raiz del proyecto  y ejecutar:

````
docker compose up
````

Nota: la primera vez que se ejecute el comando el sistema realizará la descarga de las imagenes necesarias, por lo que el proceso 
puede tardar un par de minutos.

### Requerimientos
- Es necesario contar con al menos 4Gb de memoria para el docker "backend"

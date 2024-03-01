# oesteBackEnd
_REST API para la consulta de dos entidades (Persona e Identidad) relacionadas entre si por una entidad con una relación de mucho a muchos_


### Pre-requisitos 📋

_Es necesario tener una base de datos con MySQL, los datos de conexión se establecen en el archivo de propiedades del proyecto_

## Caracteristicas del proyecto ⚙️

_Rutas y métodos para:_

* Crear una persona
* Editar una persona
* Obtener todos los registros de las personas
* Obtener una persona
* Eliminar una persona (eilminado lógico)
* Crear una identificación
* Editar una identificación
* Obtener todos los registros de identificaciones
* Obtener una identificación
* Eliminar una identificación (eilminado lógico)

_carateristicas de la entidad Persona:_

* name (string) [campo obligatorio]
* age (number)  [campo obligatorio]
* gender (string) ('H' o 'M') [campo no se deja como null]
* code (string) [método que genera una cadena de texto aleatoria de 10 caracteres y asigna en la creación]
* createdAt (date)

_caracteristicas de la entidad Identificación:_

* identificationName (string) [campo obligatorio]
* description (number) [campo obligatorio]
* createAt (date)


## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* Java 11
* [Spring Boot](https://spring.io/projects/spring-boot) - El framework web usado
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [IDE STS](https://spring.io/tools)


## Versionado 📌

Usamos [SemVer](http://semver.org/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/brakeencj/oesteBackEnd/tags).

## Autor ✒️

* **Gabriel Cervantes** - *Desarrollador Full Stack*  

## Expresiones de Gratitud 🎁

* Comenta a otros sobre este proyecto 📢
* Invita una cerveza 🍺 o un café ☕ a alguien del equipo. 
* Da las gracias públicamente 🤓.
* etc.

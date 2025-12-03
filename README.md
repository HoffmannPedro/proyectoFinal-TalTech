🐾 AlphaPets - PetShop e-Commerce

Proyecto Final TalentoTech.
Este proyecto es un e-commerce fullstack que simula una tienda de productos para mascotas.

🛠️ Tecnologías Utilizadas

Backend: Java 21 + Spring Boot 3.

Base de Datos: H2 Database

Frontend: HTML5 + React.js (vía CDN) + TailwindCSS.

🚀 Cómo Ejecutar el Proyecto

Clonar el repositorio:s

git clone [https://github.com/HoffmannPedro/proyectoFinal-TalTech.git]


Ejecutar la aplicación:

Podes importar el proyecto en Eclipse / IntelliJ IDEA como proyecto Maven y ejecutar la clase principal:
src/main/java/com/alphapets/AlphapetsApplication.java

O desde la terminal en la raíz del proyecto:

mvw spring-boot:run


Acceder a la Web:

Una vez iniciada la consola de Spring, abrir el navegador en:
👉 http://localhost:8080

🧪 Pruebas y Endpoints

El sistema cuenta con un DataLoader que carga productos de ejemplo al iniciar.

Credenciales Base de Datos (H2 Console)

Para verificar la persistencia de datos:

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:alphapets_db

User: admin

Password: (dejar vacío)

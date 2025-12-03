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



📦 1. GESTIÓN DE PRODUCTOS

Base URL: /api/productos

A. Listar todos los productos

Método: GET

Endpoint: /api/productos

Descripción: Recupera el catálogo completo de productos.


B. Obtener producto por ID

Método: GET

Endpoint: /api/productos/{id}

Descripción: Busca un producto específico por su ID.


C. Buscar productos por nombre

Método: GET

Endpoint: /api/productos/buscar?q={nombre}

Descripción: Busca productos que contengan el texto en su nombre.


D. Eliminar producto

Método: DELETE

Endpoint: /api/productos/{id}

Descripción: Elimina un producto del sistema.



➤ Crear Producto (Polimorfismo)

El sistema detecta automáticamente si es Alimento o Accesorio según el campo "tipo".

Ejemplo JSON (Alimento):

{
  "tipo": "ALIMENTO",
  "nombre": "Royal Canin Adulto",
  "descripcion": "Alimento balanceado premium, 15kg.",
  "precio": 45000.0,
  "stock": 20,
  "imagenUrl": "[https://ejemplo.com/imagen.jpg](https://ejemplo.com/imagen.jpg)",
  "pesoKg": 15.0,
  "esHipoalergenico": false
}


Ejemplo JSON (Accesorio):

{
  "tipo": "ACCESORIO",
  "nombre": "Correa Extensible",
  "descripcion": "Correa de paseo resistente.",
  "precio": 8500.0,
  "stock": 50,
  "imagenUrl": "[https://ejemplo.com/correa.jpg](https://ejemplo.com/correa.jpg)",
  "talla": "M",
  "material": "Nylon"
}


🛒 2. GESTIÓN DE PEDIDOS

Base URL: /api/pedidos

A. Ver historial de pedidos

Método: GET

Endpoint: /api/pedidos

Descripción: Lista todos los pedidos realizados.


B. Realizar un pedido (Compra)

Método: POST

Endpoint: /api/pedidos

Descripción: Crea una orden y descuenta stock.

Ejemplo JSON (Compra):

{
  "lineas": [
    {
      "productoId": 1,
      "cantidad": 2
    },
    {
      "productoId": 2,
      "cantidad": 1
    }
  ]
}

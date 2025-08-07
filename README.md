# Nutridata - Backend

Backend del proyecto **Nutridata**, una plataforma pensada para nutricionistas, que permite la gestión de productos, ventas y usuarios. Este backend está desarrollado con **Java** y **Spring Boot**, usando estructura modular.

---

## ⚙️ Tecnologías Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven
- YML para configuración

---

## 📁 Estructura del Proyecto
El proyecto sigue una arquitectura en capas, separando claramente controladores, servicios, repositorios, entidades y DTOs por módulo:

````
📁 src
└── 📁 main
├── 📁 java
│ └── 📁 com.example.nutridata
│ ├──  📁 product 📦
│ │ ├── 📁 dto
│ │ │ ├── ProductRequest.java
│ │ │ └── ProductResponse.java
│ │ ├── Product.java
│ │ ├── ProductController.java
│ │ ├── ProductRepository.java
│ │ ├── ProductService.java
│ │ └── ProductServiceImpl.java
│ ├── 📁 sale 💰
│ │ ├── dto
│ │ │ ├── SaleRequest.java
│ │ │ └── SaleResponse.java
│ │ ├── Sale.java
│ │ ├── SaleController.java
│ │ ├── SaleRepository.java
│ │ ├── SaleService.java
│ │ └── SaleServiceImpl.java
│ └── 📁 user 👤
│ ├── User.java
│ ├── UserController.java
│ ├── UserRepository.java
│ ├── UserService.java
│ └── UserServiceImpl.java
└── 📁 resources
└── application.yml
````
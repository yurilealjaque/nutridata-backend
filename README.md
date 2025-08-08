# 🥗 Nutridata Backend

**Nutridata** es una plataforma backend diseñada específicamente para nutricionistas y profesionales de la salud.  
Permite gestionar productos nutricionales, realizar seguimiento de ventas y administrar usuarios, todo a través de una **API REST** bien estructurada.

---

## ✨ Características Principales

- 🛍️ **Gestión de Productos**: CRUD completo para productos nutricionales
- 💰 **Sistema de Ventas**: Registro y seguimiento de transacciones
- 👥 **Administración de Usuarios**: Gestión de clientes y profesionales
- 🏗️ **Arquitectura Modular**: Código organizado por dominios de negocio
- 🔒 **Base de Datos Relacional**: PostgreSQL para persistencia confiable
- 📊 **API RESTful**: Endpoints bien documentados y estandarizados

---

## ⚙️ Tecnologías y Dependencias

| Tecnología        | Versión | Propósito                         |
|-------------------|---------|-----------------------------------|
| Java              | 17      | Lenguaje de programación         |
| Spring Boot       | 3.x     | Framework principal               |
| Spring Web        | -       | Desarrollo de APIs REST           |
| Spring Data JPA   | -       | Persistencia de datos             |
| PostgreSQL        | -       | Base de datos                     |
| Lombok            | -       | Reducción de boilerplate          |
| Maven             | -       | Gestión de dependencias           |

---

## 🏗️ Arquitectura del Proyecto
```
└── main/
├── java/
│ └── com.example.nutridata/
│ ├── cart/ # Módulo de carrito
│ │ ├── dto/
│ │ │ ├── CartRequest.java
│ │ │ └── CartResponse.java
│ │ ├── CartController.java
│ │ ├── CartRepository.java
│ │ ├── CartService.java
│ │ └── CartServiceImpl.java
│ │
│ ├── category/ # Módulo de categorías
│ │ ├── dto/
│ │ │ ├── CategoryRequest.java
│ │ │ └── CategoryResponse.java
│ │ ├── CategoryController.java
│ │ ├── CategoryRepository.java
│ │ ├── CategoryService.java
│ │ └── CategoryServiceImpl.java
│ │
│ ├── configEnv/ # Configuraciones de entorno
│ │ └── EnvConfig.java
│ │
│ ├── product/ # Módulo de productos
│ │ ├── dto/
│ │ │ ├── ProductRequest.java
│ │ │ └── ProductResponse.java
│ │ ├── ProductController.java
│ │ ├── ProductRepository.java
│ │ ├── ProductService.java
│ │ └── ProductServiceImpl.java
│ │
│ ├── sale/ # Módulo de ventas
│ │ ├── dto/
│ │ │ ├── SaleRequest.java
│ │ │ └── SaleResponse.java
│ │ ├── SaleController.java
│ │ ├── SaleRepository.java
│ │ ├── SaleService.java
│ │ └── SaleServiceImpl.java
│ │
│ ├── saleDetaile/ # Detalles de venta
│ │ ├── dto/
│ │ │ ├── SaleDetaileRequest.java
│ │ │ └── SaleDetaileResponse.java
│ │ ├── SaleDetailController.java
│ │ ├── SaleDetailRepository.java
│ │ ├── SaleDetailService.java
│ │ └── SaleDetailServiceImpl.java
│ │
│ ├── security/ # Seguridad y autenticación
│ │ ├── config/
│ │ │ ├── DataSeeder.java
│ │ │ └── SecurityConfig.java
│ │ ├── controller/
│ │ │ └── AuthController.java
│ │ ├── dto/
│ │ │ ├── LoginRequest.java
│ │ │ ├── LoginResponse.java
│ │ │ └── RegisterRequest.java
│ │ └── jwt/
│ │ ├── JwtAuthenticationFilter.java
│ │ └── JwtUtils.java
│ │
│ ├── model/ # Entidades
│ │ ├── NameRol.java
│ │ ├── Rol.java
│ │ └── Users.java
│ │
│ ├── repository/ # Repositorios generales
│ │ ├── RolRepository.java
│ │ └── UsersRepository.java
│ │
│ ├── service/ # Servicios generales
│ │ ├── AuthService.java
│ │ ├── UsersService.java
│ │ └── UsersServiceImpl.java
│ │
│ ├── user/ # Módulo de usuarios
│ │ ├── dto/
│ │ │ ├── UserRequest.java
│ │ │ └── UserResponse.java
│ │ ├── UserController.java
│ │ ├── UserRepository.java
│ │ ├── UserService.java
│ │ └── UserServiceImpl.java
│ │
│ └── NutridataApplication.java
│
└── resources/
└── application.yml # Archivo de configuración principal
```

**Patrones Implementados**
- Repository Pattern
- Service Layer
- DTO Pattern
- Controller-Service-Repository
- Dependency Injection

---

## 🚀 Instalación y Configuración

### Prerrequisitos
- ☕ Java 17+
- 🐘 PostgreSQL
- 📦 Maven 3.6+
- 🛠️ IDE recomendado: IntelliJ IDEA

### 📡 API Endpoints
#### 🛍️ Productos
Método	Endpoint	Descripción
GET	/api/products	Listar todos los productos
GET	/api/products/{id}	Obtener producto por ID
POST	/api/products	Crear nuevo producto
PUT	/api/products/{id}	Actualizar producto
DELETE	/api/products/{id}	Eliminar producto

#### 💰 Ventas
Método	Endpoint	Descripción
GET	/api/sales	Listar todas las ventas
GET	/api/sales/{id}	Obtener venta por ID
POST	/api/sales	Registrar nueva venta
PUT	/api/sales/{id}	Actualizar venta
DELETE	/api/sales/{id}	Eliminar venta

#### 👥 Usuarios
Método	Endpoint	Descripción
GET	/api/users	Listar todos los usuarios
GET	/api/users/{id}	Obtener usuario por ID
POST	/api/users	Crear nuevo usuario
PUT	/api/users/{id}	Actualizar usuario
DELETE	/api/users/{id}	Eliminar usuario


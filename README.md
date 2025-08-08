# 🥗 Nutridata Backend

**Nutridata** es una plataforma backend robusta diseñada específicamente para nutricionistas y profesionales de la salud.  
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

src/main/java/com/example/nutridata/
├── 📦 product/
│ ├── Product.java
│ ├── ProductController.java
│ ├── ProductService.java
│ ├── ProductServiceImpl.java
│ ├── ProductRepository.java
│ └── dto/
│ ├── ProductRequest.java
│ └── ProductResponse.java
│
├── 💰 sale/
│ ├── Sale.java
│ ├── SaleController.java
│ ├── SaleService.java
│ ├── SaleServiceImpl.java
│ ├── SaleRepository.java
│ └── dto/
│ ├── SaleRequest.java
│ └── SaleResponse.java
│
└── 👤 user/
├── User.java
├── UserController.java
├── UserService.java
├── UserServiceImpl.java
└── UserRepository.java
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
- 🛠️ IDE recomendado: IntelliJ IDEA o Spring Tool Suite

### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/yurilealjaque/nutridata-backend.git
cd nutridata-backend

2️⃣ Configurar Base de Datos
sql
Copiar
Editar
CREATE DATABASE nutridata_db;
CREATE USER nutridata_user WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE nutridata_db TO nutridata_user;
3️⃣ Configurar application.yml
yaml
Copiar
Editar
spring:
  application:
    name: nutridata
  
  datasource:
    url: jdbc:postgresql://localhost:5432/nutridata_db
    username: nutridata_user
    password: your_password
    driver-class-name: org.postgresql.Driver
  
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        format_sql: true

server:
  port: 8080
  servlet:
    context-path: /api

logging:
  level:
    com.example.nutridata: INFO

    4️⃣ Instalar Dependencias
bash
Copiar
Editar
mvn clean install
5️⃣ Ejecutar el Proyecto
bash
Copiar
Editar
mvn spring-boot:run
Servidor disponible en: http://localhost:8080/api

📡 API Endpoints
🛍️ Productos
Método	Endpoint	Descripción
GET	/api/products	Listar todos los productos
GET	/api/products/{id}	Obtener producto por ID
POST	/api/products	Crear nuevo producto
PUT	/api/products/{id}	Actualizar producto
DELETE	/api/products/{id}	Eliminar producto

💰 Ventas
Método	Endpoint	Descripción
GET	/api/sales	Listar todas las ventas
GET	/api/sales/{id}	Obtener venta por ID
POST	/api/sales	Registrar nueva venta
PUT	/api/sales/{id}	Actualizar venta
DELETE	/api/sales/{id}	Eliminar venta

👥 Usuarios
Método	Endpoint	Descripción
GET	/api/users	Listar todos los usuarios
GET	/api/users/{id}	Obtener usuario por ID
POST	/api/users	Crear nuevo usuario
PUT	/api/users/{id}	Actualizar usuario
DELETE	/api/users/{id}	Eliminar usuario

🧪 Testing
Ejecutar pruebas unitarias:

bash
Copiar
Editar
mvn test
Ejecutar pruebas de integración:

bash
Copiar
Editar
mvn verify
El proyecto incluye una colección de Bruno para testing de la API (archivo bruno.json).

🐳 Docker (Opcional)
Dockerfile

dockerfile
Copiar
Editar
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/nutridata-backend-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
docker-compose.yml

yaml
Copiar
Editar
version: '3.8'
services:
  db:
    image: postgres:15
    environment:
      POSTGRES_DB: nutridata_db
      POSTGRES_USER: nutridata_user
      POSTGRES_PASSWORD: your_password
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/nutridata_db

volumes:
  postgres_data:
🔧 Buenas Prácticas
✅ Usar Lombok para reducir boilerplate

✅ Implementar validaciones en DTOs

✅ Documentar métodos complejos

✅ Seguir convenciones de Java

✅ Usar @Transactional cuando sea necesario

Ejemplo DTO:

java
Copiar
Editar
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String name;
    
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
    
    private String description;
    private String category;
}
🤝 Contribución
🍴 Haz fork del proyecto

🌿 Crea una rama feature/nueva-funcionalidad

💾 Commit: git commit -m 'feat: nueva funcionalidad'

📤 Push a tu rama

🔁 Abre un Pull Request

Tipos de commits

feat: Nueva funcionalidad

fix: Corrección de errores

docs: Documentación

style: Formato de código

refactor: Refactorización

test: Pruebas


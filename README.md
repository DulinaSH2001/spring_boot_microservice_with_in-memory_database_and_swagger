# Product Service - Spring Boot Microservice

A RESTful microservice built with Spring Boot for managing products, featuring H2 in-memory database and Swagger API documentation.

## 🚀 Technologies Used

- **Spring Boot 3.2.2** - Application framework
- **Spring Web** - RESTful API development
- **Spring Data JPA** - Data persistence
- **H2 Database** - In-memory database
- **Springdoc OpenAPI** - API documentation (Swagger)
- **Maven** - Build tool
- **Java 17** - Programming language

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+

## 🛠️ Installation & Setup

1. **Clone or navigate to the project directory:**
   ```bash
   cd product-service
   ```

2. **Build the project:**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## 📚 API Endpoints

### Product Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/products` | Create a new product |
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |

### Example Request (Create Product)

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop",
    "price": 1200.00
  }'
```

## 📖 API Documentation

### Swagger UI
Access interactive API documentation at:
- **URL:** `http://localhost:8080/swagger-ui.html`

### OpenAPI JSON
- **URL:** `http://localhost:8080/v3/api-docs`

## 🗄️ H2 Database Console

Access the H2 database console to inspect data:

- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:productdb`
- **Username:** `sa`
- **Password:** (leave empty)

## 🧪 Testing the Application

### Using Swagger UI
1. Navigate to `http://localhost:8080/swagger-ui.html`
2. Expand the endpoint you want to test
3. Click "Try it out"
4. Enter the required parameters
5. Click "Execute"

### Using cURL

```bash
# Create a product
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Mouse","price":25.99}'

# Get all products
curl http://localhost:8080/api/products

# Get product by ID
curl http://localhost:8080/api/products/1

# Update product
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Wireless Mouse","price":29.99}'

# Delete product
curl -X DELETE http://localhost:8080/api/products/1
```

## 📁 Project Structure

```
product-service/
├── src/
│   ├── main/
│   │   ├── java/com/sliit/productservice/
│   │   │   ├── ProductServiceApplication.java
│   │   │   ├── controller/
│   │   │   │   └── ProductController.java
│   │   │   ├── entity/
│   │   │   │   └── Product.java
│   │   │   └── repository/
│   │   │       └── ProductRepository.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## 🎯 Learning Outcomes

✅ Create Spring Boot microservices  
✅ Implement RESTful APIs with CRUD operations  
✅ Use Spring Data JPA for database operations  
✅ Configure H2 in-memory database  
✅ Integrate Swagger for API documentation  
✅ Test APIs using Swagger UI

## 📝 Notes

- The H2 database is in-memory, so data will be lost when the application stops
- SQL queries are logged in the console (set `spring.jpa.show-sql=true`)
- The application runs on port 8080 by default

## 🤝 Author

Created for SLIIT DevOps Lab 3
# spring_boot_microservice_with_in-memory_database_and_swagger

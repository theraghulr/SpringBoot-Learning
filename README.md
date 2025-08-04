# 🧠 SpringBoot-Learning

Welcome to my **Spring Boot Learning Repository**!  
This repo contains hands-on practice, CRUD operations, and mini-projects I've built while learning **Spring Boot**. It covers building REST APIs, implementing service layers, and connecting to MySQL using Spring Data JPA.

---

## 🚀 Technologies Used

- ☕ Java 17+
- 🌱 Spring Boot
- 🌐 Spring Web
- 📦 Spring Data JPA
- 🐬 MySQL
- 🛠️ IntelliJ IDEA / VS Code
- 📮 Postman (for API testing)

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/
    │   └── com.springboot.learning.SpringBoot/
    │       ├── Controller/
    │       ├── Entity/
    │       ├── Repository/
    │       ├── Service/
    │       └── Application.java
    └── resources/
        ├── application.properties
        └── data.sql
```

---

## 📚 What I’ve Learned So Far

- ✅ Creating RESTful APIs using Spring Boot
- ✅ Working with `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc.
- ✅ Dependency Injection using `@Autowired`
- ✅ Defining Entity classes and repositories with Spring Data JPA
- ✅ Integrating MySQL with Spring Boot
- ✅ Testing endpoints using Postman

---

## 🛠️ How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/spring-boot-learning.git
cd spring-boot-learning
```

### 2️⃣ Configure MySQL

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3️⃣ Run the Application

From your IDE, or using the terminal:

```bash
./mvnw spring-boot:run
```

### 4️⃣ Test the APIs (using Postman or similar tools)

📌 Sample Endpoints:

| Method | Endpoint            | Description               |
|--------|---------------------|---------------------------|
| GET    | `/Todo`             | Get all todos             |
| GET    | `/Todo/{id}`        | Get todo by ID            |
| POST   | `/Todo/create`      | Create a new todo         |
| PUT    | `/Todo/{id}`        | Update an existing todo   |
| DELETE | `/Todo/{id}`        | Delete a todo             |

---

## 🔭 Todo (Upcoming Learning Goals)

- 🔍 Spring Boot Validation (`@Valid`, custom validators)
- 🧼 Global Exception Handling with `@ControllerAdvice`
- 🧪 Unit & Integration Testing (JUnit + Mockito)
- 🔐 Spring Security (Basics)
- ☁️ Deployment (Heroku / Render)

---

## 🙌 Contributions

This is a learning-focused repository, but feel free to fork or open an issue if you’d like to discuss improvements or collaborate!

---

## 📌 License

This project is for educational purposes only.



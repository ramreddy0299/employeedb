# EmployeeDB REST API using Spring Boot, Swagger & Postman

This is a simple **Employee Database REST API** built with **Spring Boot**. It allows performing **CRUD operations** (Create, Read, Update, Delete) on employee records. The API is designed using RESTful principles, documented with **Swagger UI**, and tested using **Postman**.

## Features

- Add new employees to the database.
- Fetch all employees or specific employee by ID.
- Update employee details.
- Delete employee records.
- API documentation with **Swagger UI**.
- API testing with **Postman**.

## Technologies Used

- Java 17+
- Spring Boot (Spring Web, Spring Data JPA)
- H2 Database (or MySQL)
- Swagger (SpringFox / OpenAPI)
- IntelliJ IDEA
- Postman

## Project Structure

| Layer          | Responsibility                                 |
|----------------|------------------------------------------------|
| Controller     | Handles HTTP requests (API endpoints)          |
| Service        | Business logic layer                           |
| Repository     | Database operations using Spring Data JPA      |
| Model          | Entity classes (Employee model)                |
| Configuration  | Swagger and other configurations               |

## API Endpoints

| Method | Endpoint                    | Description               |
|--------|-----------------------------|---------------------------|
| GET    | `/api/employees`             | Get all employees         |
| GET    | `/api/employees/{id}`        | Get employee by ID        |
| POST   | `/api/employees`             | Add a new employee        |
| PUT    | `/api/employees/{id}`        | Update an employee        |
| DELETE | `/api/employees/{id}`        | Delete an employee        |

## Running the Application

1. Clone this repository.
2. Open the project in **IntelliJ IDEA**.
3. Update database configurations in `application.properties` if using MySQL.
4. Run the Spring Boot application.
5. Open browser and access **Swagger UI** at:  
   `http://localhost:8080/swagger-ui/`
6. Use **Postman** for manual API testing if needed.

## Testing with Postman

- Import the Postman collection (or create requests manually).
- Test CRUD operations on `/api/employees` endpoints.
- Add `Content-Type: application/json` header for POST & PUT requests.
- Example request body for adding an employee:
  ```json
  {
    "id": "1",
    "FirstName": "Ram",
    "LastName": "Reddy",
    "Email": "ram@gmail.com"
  }

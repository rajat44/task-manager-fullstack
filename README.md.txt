Task Manager Full Stack Application

A full-stack Task Management application built using:

Backend: Spring Boot 3 + PostgreSQL

Frontend: React + TypeScript

API Documentation: Swagger/OpenAPI

Testing: JUnit + Mockito + Playwright

Containerization: Docker & Docker Compose

🚀 Features
Backend

Create, Read, Update, Delete Tasks

Pagination & Sorting

Filtering by completion status & due date range

DTO layer with validation

Global exception handling

Swagger documentation

Unit tests

Clean layered architecture

Frontend

SPA using React + TypeScript

Task list view

Add/Edit task view

Toggle completion from list

Client-side routing

API integration using Axios

Basic state management

Playwright E2E test

🏗 Architecture

Backend follows layered architecture:

Controller → Service → Repository → Database


DTO pattern is used to decouple entity from API layer.

Filtering implemented using:

Spring Data JPA Specifications

Pagination implemented using:

Pageable

📦 Prerequisites

You must have installed:

Java 21

Maven 3.9+

Node 20+

Docker & Docker Compose

🛠️ RUN USING DOCKER (Recommended)

This is the easiest way.

From root folder:

docker-compose up --build


Wait until containers start.

Access:

Frontend:

http://localhost:3000


Backend:

http://localhost:8080


Swagger:

http://localhost:8080/swagger-ui.html


Stop containers:

docker-compose down

🛠️ RUN BACKEND LOCALLY (Without Docker)
1. Start PostgreSQL

You can use Docker:

docker run --name postgres \
-e POSTGRES_DB=taskdb \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=postgres \
-p 5432:5432 \
-d postgres:15

2. Configure application.yml

Make sure:

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/taskdb
    username: postgres
    password: postgres

3. Run Backend
cd backend
mvn clean install
mvn spring-boot:run


Backend runs on:

http://localhost:8080

🛠️ RUN FRONTEND LOCALLY
cd frontend
npm install
npm start


App runs at:

http://localhost:3000

🧪 Running Tests
Backend Unit Tests
cd backend
mvn test

Frontend E2E (Playwright)
cd frontend
npx playwright install
npx playwright test

📘 API Documentation

Swagger available at:

http://localhost:8080/swagger-ui.html

📌 API Endpoints
Create Task

POST /api/tasks

Get All Tasks

GET /api/tasks?page=0&size=10&sort=dueDate,desc

Optional filters:

?completed=true
?startDate=2025-01-01T00:00:00
?endDate=2025-12-31T00:00:00

Update Task

PUT /api/tasks/{id}

Delete Task

DELETE /api/tasks/{id}

🔒 Security Considerations (Production)

Add JWT authentication

Add Spring Security

Enable HTTPS

Add input sanitization

Rate limiting

DB indexing on:

is_completed

due_date

📈 Scalability Considerations

For production:

Use Redis for caching

Horizontal scaling via load balancer

Database connection pooling tuning

Use CI/CD pipeline

Deploy using AWS ECS / Kubernetes

🐳 Docker Architecture

Services:

postgres

backend

frontend

All connected via Docker network.

🧠 Design Decisions

DTO used to avoid exposing entity

Validation annotations for input safety

Global exception handler for consistent API errors

Specification API for dynamic filtering

Pagination mandatory for scalability

📂 Project Structure
backend/
frontend/
docker-compose.yml
README.md

👨‍💻 Author

Rajat Raj
Senior Java Developer

📌 License

This project is for demonstration/interview purposes.
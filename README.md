# Training Center Management API

## Overview

The **Training Center Management API** is a Spring Boot application that allows users to manage training centers, including storing details such as center name, address, student capacity, courses offered, and contact details.

## Features

- Create a training center
- Retrieve all training centers
- Store training center details with validation
- Uses PostgreSQL as the database
- Implements Hibernate for ORM

## Tech Stack

- **Backend:** Spring Boot, Spring Data JPA
- **Database:** PostgreSQL
- **Build Tool:** Gradle/Maven
- **Validation:** Jakarta Validation API
- **Dependency Injection:** Spring Boot

## Installation

### Prerequisites

Ensure you have the following installed:

- Java 17+
- PostgreSQL
- Gradle/Maven
- Docker (optional)

### Clone the Repository

```sh
git clone https://github.com/AnirudhSharma777/-Backend_Traini8_Anirudh.git
cd Backend_Traini_Anirudh
```

### Configure Database

Update `application.properties` or `application.yml` with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/training_center
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Run the Application

```sh
./mvnw spring-boot:run  # If using Maven
# OR
./gradlew bootRun        # If using Gradle
```

## API Endpoints

### 1. Create Training Center

**Endpoint:** `POST /api/training-centers`
**Request Body:**

```json
{
  "centerName": "Tech Learning Hub",
  "centerCode": "ABC123XYZ789",
  "address": {
    "street": "123 Main Street",
    "city": "New York",
    "state": "NY",
    "zipCode": "10001",
    "country": "USA"
  },
  "studentCapacity": 200,
  "courses": ["Java", "Spring Boot", "ReactJS", "Docker"],
  "contactEmail": "info@techlearninghub.com",
  "contactPhoneNumber": "1234567890"
}
```

### 2. Retrieve All Training Centers

**Endpoint:** `GET /api/training-centers`
**Response:**

```json
[
  {
    "id": "1a2b3c4d",
    "centerName": "Tech Learning Hub",
    "centerCode": "ABC123XYZ789",
    "address": {
      "street": "123 Main Street",
      "city": "New York",
      "state": "NY",
      "zipCode": "10001",
      "country": "USA"
    },
    "studentCapacity": 200,
    "courses": ["Java", "Spring Boot", "ReactJS", "Docker"],
    "contactEmail": "info@techlearninghub.com",
    "contactPhoneNumber": "1234567890"
  }
]
```

## Error Handling

- **400 Bad Request** - Validation errors
- **404 Not Found** - Resource not found
- **500 Internal Server Error** - Unexpected server errors

## License

This project is licensed under the MIT License.

## Author

Anirudh - [GitHub](https://github.com/AnirudhSharma777)


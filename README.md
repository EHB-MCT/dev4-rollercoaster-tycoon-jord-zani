# Rollercoaster Tycoon

This project is the for the Rollercoaster Tycoon management application. The backend is built using Kotlin and Spring Boot, and it interacts with an H2 database. The frontend is developed using Vue.js.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Sources and References](#sources-and-references)
- [License](#license)

## Features

- View a list of all attractions in the theme park.
- Add, edit, or delete attractions.
- Manage categories of attractions.
- Record and track maintenance for attractions.
- Report and resolve faults for attractions.
- View the status of attractions including faults and maintenance schedules.

## Technologies Used

- **Backend:**
  - Kotlin
  - Spring Boot
  - H2 Database
  - JPA (Java Persistence API)

- **Frontend:**
  - Vue.js

## Getting Started

### Prerequisites

- JDK 11 or later
- Maven
- Node.js and npm (for the frontend)
- IntelliJ IDEA (recommended for development)

### Installation

1. Clone the repository:

```sh
git clone https://github.com/yourusername/rollercoaster-tycoon.git
cd rollercoaster-tycoon
```

2. Set up the backend:

- Navigate to the backend directory:
  
```sh
cd Backend
```

- Ensure you have the correct JDK installed and configured.
- Import the project into IntelliJ IDEA as a Maven project.

3. Set up the frontend:

- Navigate to the frontend directory:
  
```sh
cd Frontend
```

- Install the dependencies:
  
```sh
npm install
```

### Running the Application

1. **Backend:**
  
- From IntelliJ IDEA:
  - Right-click on `RollercoasterTycoonApplication.kt` and select `Run 'RollercoasterTycoonApplication'`.

- From the terminal:
  
```sh
./mvnw spring-boot:run
```

2. **Frontend:**
  
```sh
npm run serve
```

The application will be available at `http://localhost:8080` for the backend and `http://localhost:8081` for the frontend.

## API Endpoints

- `GET /api/attractions` - Get all attractions.
- `POST /api/attractions` - Add a new attraction.
- `PUT /api/attractions/{id}` - Update an attraction.
- `DELETE /api/attractions/{id}` - Delete an attraction.
- `GET /api/categories` - Get all categories.
- `POST /api/categories` - Add a new category.
- `PUT /api/categories/{id}` - Update a category.
- `DELETE /api/categories/{id}` - Delete a category.
- `GET /api/faults` - Get all faults.
- `POST /api/faults` - Report a fault.
- `PUT /api/faults/{id}/resolve` - Mark a fault as resolved.
- `GET /api/maintenance` - Get maintenance records.
- `POST /api/maintenance` - Add a maintenance record.

# Sources and References

This file lists the sources and references used during the development of the Rollercoaster Tycoon project.

## Backend

### Documentation and Tutorials

1. **Spring Boot Documentation**
   - Official documentation: [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
   - Used for setting up and configuring the Spring Boot application, including dependency management, application properties, and running the application.

2. **Spring Data JPA Documentation**
   - Official documentation: [Spring Data JPA Reference Guide](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
   - Used for understanding JPA repositories, entity mapping, and database operations.

3. **H2 Database Documentation**
   - Official documentation: [H2 Database Engine](http://www.h2database.com/html/main.html)
   - Used for configuring the H2 in-memory database and writing SQL queries for testing.

4. **Kotlin Documentation**
   - Official documentation: [Kotlin Language Documentation](https://kotlinlang.org/docs/reference/)
   - Used for writing Kotlin code, including syntax, data classes, and functions.

5. **Spring Boot and Kotlin Guide**
   - Spring blog: [Using Kotlin with Spring Boot](https://spring.io/guides/tutorials/spring-boot-kotlin/)
   - Used for integrating Kotlin with Spring Boot and writing idiomatic Kotlin code in a Spring Boot application.

### Online Articles and Blog Posts

1. **Spring Boot REST API Tutorial**
   - Baeldung: [Building a RESTful Web Service with Spring Boot](https://www.baeldung.com/spring-boot-rest-api)
   - Used for creating RESTful endpoints and handling HTTP requests in the Spring Boot application.

2. **Exception Handling in Spring Boot**
   - Baeldung: [Exception Handling in Spring Boot](https://www.baeldung.com/exception-handling-for-rest-with-spring)
   - Used for implementing global exception handling in the REST API.

3. **Spring Boot and H2 Database Integration**
   - Baeldung: [Guide to Spring Boot with H2](https://www.baeldung.com/spring-boot-h2-database)
   - Used for configuring the H2 database and performing CRUD operations.

### Stack Overflow

1. **Various Kotlin and Spring Boot Questions**
   - Used for troubleshooting specific issues and understanding best practices.

### Libraries and Tools

1. **Spring Boot**
   - Dependency: `org.springframework.boot:spring-boot-starter-web`
   - Dependency: `org.springframework.boot:spring-boot-starter-data-jpa`

2. **H2 Database**
   - Dependency: `com.h2database:h2`

3. **Jackson for Kotlin**
   - Dependency: `com.fasterxml.jackson.module:jackson-module-kotlin`

4. **Kotlin Standard Library**
   - Dependency: `org.jetbrains.kotlin:kotlin-stdlib-jdk8`
   - Dependency: `org.jetbrains.kotlin:kotlin-reflect`

5. **Maven**
   - Used for project management and dependency management.

### GitHub Repositories

1. **Spring Boot Kotlin Sample**
   - GitHub Repository: [spring-guides/tut-spring-boot-kotlin](https://github.com/spring-guides/tut-spring-boot-kotlin)
   - Used as a reference for project structure and configuration.

### Other Resources

1. **IntelliJ IDEA**
   - Official documentation: [IntelliJ IDEA Documentation](https://www.jetbrains.com/idea/documentation/)
   - Used for configuring the IDE, running the application, and debugging.
  
2. **ChatGPT**
   - Used for examples and resolving errors.

## Frontend

### Documentation and Tutorials

1. **Vue.js Documentation**
   - Official documentation: [Vue.js Guide](https://vuejs.org/v2/guide/)
   - Used for setting up and configuring the Vue.js application, understanding component-based architecture, and managing state.

2. **Vue Router Documentation**
   - Official documentation: [Vue Router](https://router.vuejs.org/)
   - Used for configuring client-side routing in the Vue.js application.

3. **Vue CLI Documentation**
   - Official documentation: [Vue CLI](https://cli.vuejs.org/)
   - Used for setting up the Vue.js development environment and managing build configurations.

4. **Axios Documentation**
   - Official documentation: [Axios](https://axios-http.com/docs/intro)
   - Used for making HTTP requests from the Vue.js frontend to the Spring Boot backend.

### Online Articles and Blog Posts

1. **Vue.js CRUD Application Tutorial**
   - DigitalOcean: [Build a Basic CRUD App with Vue.js and Node](https://www.digitalocean.com/community/tutorials/vuejs-crud-app)
   - Used for implementing CRUD operations in the Vue.js application.

2. **Handling Forms in Vue.js**
   - Vue Mastery: [Handling Forms in Vue](https://www.vuemastery.com/blog/forms-in-vue/)
   - Used for creating and managing forms in Vue.js components.

3. **Component Communication in Vue.js**
   - Vue Mastery: [Component Communication in Vue](https://www.vuemastery.com/blog/component-communication/)
   - Used for managing parent-child component interactions and data flow.

### Stack Overflow

1. **Various Vue.js Questions**
   - Used for troubleshooting specific issues and understanding best practices.

### Libraries and Tools

1. **Vue.js**
   - Dependency: `vue`
   - Dependency: `vue-router`

2. **Axios**
   - Dependency: `axios`

3. **Vue CLI**
   - Tool for setting up the Vue.js project and managing configurations.

### GitHub Repositories

1. **Vue.js Examples**
   - GitHub Repository: [vuejs/vue-hackernews-2.0](https://github.com/vuejs/vue-hackernews-2.0)
   - Used as a reference for best practices and project structure in Vue.js applications.

### Other Resources

1. **Visual Studio Code**
   - Official documentation: [Visual Studio Code Documentation](https://code.visualstudio.com/docs)
   - Used for configuring the IDE, running the Vue.js development server, and debugging.

2. **ChatGPT**
   - Used for examples and resolving errors.


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

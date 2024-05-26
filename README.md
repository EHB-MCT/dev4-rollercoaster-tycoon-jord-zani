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

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

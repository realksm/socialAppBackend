# Social App - Backend Implementation

## Overview

Social App is a social media platform designed to connect people and facilitate social interactions. This repository contains the backend implementation of the application, built using the Spring Boot framework.

## Features

- **Spring Boot 3.1.4:** Built on the latest version of the Spring Boot framework.
- **Spring Data JPA:** Utilizing JPA for easy and efficient data persistence.
- **Spring Security:** Ensuring the security of the application with Spring Security.
- **Validation:** Incorporates Spring Boot Starter Validation for data validation.
- **Web Support:** Leverages Spring Boot Starter Web for web application development.
- **DevTools:** Includes Spring Boot DevTools for a smoother development experience.
- **MySQL Integration:** Uses MySQL as the relational database, with the connector provided by `mysql-connector-j`.
- **Lombok:** Enhances code readability and conciseness with Lombok annotations.
- **JSON Web Token (JWT):** Implements JWT for secure authentication and authorization.
- **WebSocket:** Utilizes Spring Boot Starter WebSocket for real-time communication.
- **Mail Integration:** Includes Spring Boot Starter Mail for email functionality.

## Prerequisites

- Java 17
- MySQL Database
- Maven

## Setup Instructions

1. Clone the repository: `git clone <repository_url>`
2. Navigate to the project directory: `cd social-app`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

Make sure to configure the database connection details in the `application.properties` file.

## Configuration

- Database Configuration: Update `application.properties` with your MySQL database connection details.
- JWT Configuration: Customize JWT settings in the `SecurityConfig` class.
- Additional Configuration: Explore other configuration files for fine-tuning.

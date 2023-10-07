# Geekseat Technical Test

This is a Spring Boot application for answer the Technical Test Question at Geekseat.
I create this project without database so you can run this project without changes
the application and database settings in the src/main/resources/application.properties file.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or higher installed.
- Maven build tool installed.
- Git installed (optional, for cloning the repository).

## Getting Started

### Clone the Repository

You can clone this repository using the following command:

```bash
git clone https://github.com/keys2505/geekseat.git
```

### Build the Project
Navigate to the project directory and build the application using Maven:
```bash
cd geekseat
mvn clean install
```

### Run the Application
You can run the Spring Boot application using the spring-boot:run Maven goal:
```bash
mvn spring-boot:run
```
Alternatively, you can run the JAR file generated in the target directory:
```bash
java -jar target/app-0.0.1-SNAPSHOT.jar
```
The application will start and be accessible at http://localhost:8080

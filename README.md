**Tracking API Application**

**Overview**

This application is a RESTful API for generating unique tracking numbers for parcels. The API is designed to be stateless, scalable, and efficient, with the ability to handle high concurrency.

**Features**

Generate unique tracking numbers matching the regex pattern ^[A-Z0-9]{1,16}$.
Stateless tracking number generation to ensure scalability.
RESTful endpoint for retrieving tracking numbers.
Implements best practices in project structure and configuration.
Asynchronous processing for high-performance requests.

**Directory Structure**

src/main/java/com/example/trackingapi
  ├── controller
  │     └── TrackingNumberController.java
  ├── service
  │     └── TrackingNumberService.java
  ├── util
  │     └── TrackingNumberGenerator.java
  ├── entity
  │     └── TrackingNumber.java
  ├── repository
  │     └── TrackingNumberRepository.java
  └── TrackingApiApplication.java

**Explanation of Modules**

**controller**:
Contains TrackingNumberController, which exposes the REST endpoint to generate tracking numbers.

**service**:
Contains TrackingNumberService, where the business logic for generating and validating tracking numbers resides.

**util**:
Contains TrackingNumberGenerator, which provides the core logic for stateless and unique tracking number generation.

**entity**:
Contains TrackingNumber, a model class representing the tracking number data structure.

**repository**:
Contains TrackingNumberRepository, which interfaces with the database for persisting tracking numbers if needed.

**TrackingApiApplication**:
The main application entry point for Spring Boot.

Prerequisites

Java 17+
Maven 3.8+
Spring Boot 3.1+
H2 Database (in-memory database for testing purposes)

**Configuration**
The application uses the following configuration in application.yml:
spring:
  application:
    name: TrackingApiApplication
server:
  port: 8090
spring:
  datasource:
    url: jdbc:h2:mem:trackingdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
  h2:
    console:
      enabled: true
      path: /h2-console
H2 Console: Access the H2 in-memory database at http://localhost:8090/h2-console.

**Running the Application**

Clone the repository:
git clone <repository_url>
Navigate to the project directory:
cd tracking-api
Build the project:
mvn clean install
Run the application:
mvn spring-boot:run
Access the API endpoint:
GET /next-tracking-number

**Example request:**

GET (https://ticket-tracking-application-p89d.onrender.com/api/v1/next-tracking-number)
Parameters:
  origin_country_id=US
  destination_country_id=IN
  weight=1.234
  created_at=2025-01-20T15:45:30+05:30
  customer_id=123e4567-e89b-12d3-a456-426614174000
  customer_name=ExampleCustomer
  customer_slug=example-customer


**H2 Database Console**: Access at http://localhost:8090/h2-console.

Logging: Logs are configured to print to the console for easier debugging.
Asynchronous Processing: The API leverages Spring's @Async for better performance under high concurrency.
Future Enhancements
Add support for distributed ID generation (e.g., Snowflake IDs).
Integrate with external databases like PostgreSQL for production.
Implement rate-limiting to prevent abuse of the API.
Add API authentication and authorization.

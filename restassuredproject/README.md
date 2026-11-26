# REST Assured API Automation Framework

A Maven-based Java API automation project using REST Assured and TestNG. The framework demonstrates JSON payload creation, API request validation, dynamic JSON handling, and reusable automation utilities.

## Technology Stack

- Java 11
- Apache Maven
- REST Assured 5.5.6
- TestNG 7.11.0
- Hamcrest 3.0
- Maven Surefire 3.5.4

## Project Structure

```text
restassuredproject/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/restassured/
    │   ├── practice/
    │   │   └── GoogleAppAPI.java
    │   └── utilities/
    │       ├── Payloads.java
    │       └── ReusableMethods.java
    └── test/java/com/restassured/tests/
        ├── CompareTotalAmountTest.java
        └── DynamicJsonTest.java
```

- `practice` contains examples of REST API workflows.
- `utilities` contains reusable payload builders and JSON response helpers.
- `tests` contains TestNG API test cases.

## Prerequisites

Install the following tools:

- Java JDK 11 or newer
- Apache Maven
- Visual Studio Code or another Java IDE
- Internet access for the external API endpoints used by the tests

Verify the installations:

```powershell
java -version
mvn -version
```

## Getting Started

Clone or open the project, then enter the Maven project directory:

```powershell
cd restassuredproject
```

Download dependencies and compile the project:

```powershell
mvn clean compile
```

## Run Tests

Run the complete TestNG suite:

```powershell
mvn test
```

Run a specific test class:

```powershell
mvn -Dtest=CompareTotalAmountTest test
mvn -Dtest=DynamicJsonTest test
```

Run all tests matching a name pattern:

```powershell
mvn -Dtest=*Test test
```

## Test Reports

After running tests, Maven generates reports in:

```text
target/surefire-reports/
```

Open the generated text or XML reports to inspect test results and failures.

## Test Coverage

### Compare Total Amount

`CompareTotalAmountTest` calculates the total value of all courses from the course JSON payload and compares it with the dashboard purchase amount.

### Dynamic JSON

`DynamicJsonTest` sends a dynamically generated book payload to a library API and validates the HTTP 200 response.

## API Endpoints Used

- Google Places-style APIs:
  - `https://rahulshettyacademy.com/maps/api/place/...`
- Library API:
  - `http://216.10.245.166/Library/Addbook.php`

Some public demo endpoints may be unavailable or may return changed responses. Update the endpoints and payload values when required.

## Build from Command Line

Create a compiled JAR and run the Maven lifecycle:

```powershell
mvn clean package
```

Build output is written to `target/`.

## Good Practices

- Keep reusable payload and response methods under `src/main/java`.
- Keep TestNG test classes under `src/test/java`.
- Use environment variables for real credentials or tokens.
- Do not commit API keys or generated `target/` files.
- Use meaningful test names and assertions.

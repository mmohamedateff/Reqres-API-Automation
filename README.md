# Reqres API Automation
Using any programming language ex: Java with Rest Assured, , design and implement a small  suite of automated API tests for a user management workflow using the public API available at  https://reqres.in/
# Reqres API Automation Test Suite

This project is a Java-based REST API test automation suite designed to test user management functionalities provided by the public [Reqres API](https://reqres.in/). The automation follows a real-world workflow of creating, updating, retrieving, and deleting a user, along with verifying the outcomes using assertions and detailed test reports.

---

## 📋 Task Overview

### Scenario

Using any programming language and Rest Assured, implement a small suite of automated API tests for a user management workflow using the public API available at:

🔗 `https://reqres.in/`

### Tasks

- **Create User**: `POST /users` – Capture the `id` from the response.
- **Update User**: `PUT /users/{id}` – Use the captured ID and update the job.
- **Get User (Verify Update)**: `GET /users/{id}` – Validate the updated job (Note: see limitation below).
- **Delete User**: `DELETE /users/{id}`
- **Get User (Verify Deletion)**: `GET /users/{id}` – Should return 404

### Focus

- Dynamic data handling: Extracting data (e.g., ID) from one response and using it in subsequent requests.
- Report test results clearly with a reporting framework.

---

## ✅ Technologies & Tools Used

| Tool              | Purpose                                      |
|-------------------|----------------------------------------------|
| Java 8            | Programming language                         |
| TestNG            | Test framework                               |
| Rest Assured      | API testing library                          |
| Jackson           | JSON serialization/deserialization           |
| Java Faker        | Fake data generation                         |
| Allure Reports    | Test reporting (with `@Feature` & `@Story`)  |
| Maven             | Project build tool                           |






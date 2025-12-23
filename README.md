📌 Overview

This repository contains a Hybrid Automation Testing Framework designed to automate both API and UI test scenarios using industry-standard tools and best practices.

The framework is built with Java + TestNG + Maven, following a backend-first execution strategy, where API tests validate system behavior and prepare data, followed by UI tests for end-to-end user flow validation.

This structure closely aligns with real-world SDET and enterprise automation practices.

✨ Key Highlights

Hybrid framework supporting API + UI automation

Backend-first execution (API → UI)

POJO-based request & response handling

Data-driven testing using TestNG DataProviders

Page Object Model (POM) for UI automation

Centralized configuration and utilities

Controlled execution using TestNG XML

CI/CD-friendly and scalable design

🛠️ Technology Stack
Layer	Tools
Programming Language	- Java
UI Automation	- Selenium WebDriver
API Automation -	REST Assured
Test Framework	- TestNG
Build Tool	- Maven
Design Pattern	- Page Object Model (POM)
Data Handling	- POJO, TestNG DataProvider
Version Control	- Git & GitHub


🔗 API & UI Integration Strategy
🔹 API Layer

Validates REST endpoints and business logic

Uses POJO classes for serialization & deserialization

Prepares test data required for UI execution

Handles query parameters, path parameters, and request bodies

🔹 UI Layer

Executes end-to-end user flows
Uses Page Object Model for maintainability

📌 Why this approach?

Faster execution

Reduced UI flakiness

Clear separation of concerns

Reliable test data setup

📦 Payload & Data Handling

JSON payloads mapped to POJO classes

📊 Data-Driven Testing

Implemented using TestNG DataProvider

Supports:

Multiple test methods sharing a single DataProvider

Different POJOs per test scenario

Method-based data selection when required

▶️ Test Execution
🔹 Using TestNG XML

Execution order is controlled using testng.xml:

API Tests → UI Tests

🔹 Run from IntelliJ

Right-click testng.xml

Select Run

⚙️ Configuration Management

Centralized configuration for:

Base URLs

Environment setup

Browser selection

Easily extendable for multi-environment execution

✅ Best Practices Followed

Clean code and modular design

Reusability and scalability

Minimal hardcoding

Separation of API and UI concerns

CI/CD-ready structure

🔮 Future Enhancements

Test execution reports (Allure / Extent)

CI/CD pipeline integration

👨‍💻 Author

Vivek Kumar
Automation Test Engineer | SDET Aspirant

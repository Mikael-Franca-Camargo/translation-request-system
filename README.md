# Translation Request Management System – TranslationRequest Module

![Java](https://img.shields.io/badge/Java-17+-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) ![H2 Database](https://img.shields.io/badge/H2-Database-lightgrey) ![REST API](https://img.shields.io/badge/REST-API-orange) ![i18n](https://img.shields.io/badge/i18n-EN%2FPT-purple)

Translation request management system developed using **Java 17+ and Spring Boot**, simulating an internal corporate workflow and prepared for global use.

Demonstrates hands-on experience in software development, including **basic business rule validation**, **internationalization (i18n)**, and **REST API implementation**, with a focus on learning and practical application.

> ⚠ Note: The root package (`com.project.mini_integrated_erp`) retains its original name, as this code was adapted from a previous ERP-inspired project. This repository focuses solely on the Translation Request module.

---

## 🛠 Key Technologies

- **Java 17+ / Spring Boot 3**  
- **Spring Data JPA / H2 Database**  
- **Maven / IntelliJ IDEA**  
- **Postman / Insomnia** (for API testing)  

---

## ✨ Main Features

- Create, list, retrieve, and approve translation requests via **REST API**.  
- Includes a workflow with basic business logic to prevent re-approval of translation requests.  
- **Centralized exception handling** (`GlobalExceptionHandler`) with consistent responses (`ApiResponse`).  
- **Internationalization (i18n)** support: error messages in Portuguese and English via the `Accept-Language` header.  

> This backend works with the [frontend repository](https://github.com/Mikael-Franca-Camargo/translation-request-system-frontend).

---

## 🆕 Recent Improvements

- Configured **i18n**: messages in multiple languages using Spring `MessageSource`.  
- Updated controllers to respect `Accept-Language` for localized responses.  
- Cleaner, more maintainable code with **no hardcoded strings**.  
- Easy to expand for new languages.  
- Helps build practical skills in workflow management, error handling, and internationalization.

---

## 📂 Package Structure

```text
mini-integrated-erp
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com
│  │  │     └─ project
│  │  │        └─ mini_integrated_erp
│  │  │           ├─ shared
│  │  │           │  ├─ ApiResponse.java
│  │  │           │  ├─ GlobalExceptionHandler.java
│  │  │           │  ├─ InvalidRequestException.java
│  │  │           │  ├─ MessageConfig.java
│  │  │           │  ├─ NotFoundException.java
│  │  │           ├─ translation
│  │  │           │  ├─ TranslationRequest.java
│  │  │           │  ├─ TranslationRequestController.java
│  │  │           │  ├─ TranslationRequestDTO.java
│  │  │           │  ├─ TranslationRequestRepository.java
│  │  │           │  ├─ TranslationRequestService.java
│  │  │           │  └─ RequestStatus.java
│  │  │           ├─ MiniIntegratedErpApplication.java
│  ├─ resources
│  │  ├─ application.properties
│  │  ├─ messages_en.properties
│  │  ├─ messages_pt.properties
│  └─ test
│     └─ java
│        └─ com
│           └─ project
│              └─ mini_integrated_erp
│                 └─ MiniIntegratedErpApplicationTests.java
```

---

## ⚡ Usage Examples

### Create a Translation Request

**POST** `http://localhost:8080/translation-requests`

```json
{
  "requesterName": "Company ABC",
  "wordCount": 1500
}
```
### Approve a Translation Request

**POST** `http://localhost:8080/translation-requests/1/approve`
Header: Accept-Language: en-US

Example of Internationalized Error Response

```json
{
  "success": false,
  "message": "TranslationRequest has already been approved"
}
```
---

## 🚀 Running Locally

```bash
git clone <https://github.com/Mikael-Franca-Camargo/translation-request-system>
cd mini-integrated-erp
```
### Linux / Mac
```bash
./mvnw spring-boot:run
```
### Windows
```bash
mvnw.cmd spring-boot:run
```
Test API endpoints using Postman or Insomnia:
`http://localhost:8080/translation-requests`

---

## 🛠 Next Steps

- Unit and integration tests (JUnit + Mockito)  
- Authentication and authorization (Spring Security)  
- Connect to a real database (PostgreSQL / MySQL)  
- Expand workflow statuses (IN_PROGRESS, COMPLETED)  
- Integration with external translation APIs

---

## 📘 What I Learned

- Structuring a **Spring Boot project** with controllers, services, and repositories  
- Designing simple business workflows (preventing re-approval of requests)  
- **Centralized error handling** using `GlobalExceptionHandler` for consistent API responses  
- **Internationalization (i18n)**: handling `Accept-Language` headers and providing messages in multiple languages  
- Using **H2 database and Spring Data JPA** for basic CRUD operations  
- **Testing APIs with Postman/Insomnia** to ensure endpoints behave as expected  
- **Iterative development**: improving code and documentation as I learned new concepts


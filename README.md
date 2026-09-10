# ⚙️ AI Response Generator — Backend

A **Spring Boot REST API** for an AI-powered Response Generator that helps content creators generate responses to comments and feedback using the **Google Gemini API**.

The backend handles authentication, response management, CRUD operations, database communication, and AI response generation.

## ✨ Features

* 🔐 User authentication
* 🤖 Gemini API integration
* 💬 AI-generated responses for comments and feedback
* ➕ Create response records
* 📋 Get saved responses
* ✏️ Update response records
* 🗑️ Delete response records
* 🔄 Complete CRUD operations
* 🔗 RESTful APIs
* 🗄️ MySQL database integration

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Security
* REST APIs
* MySQL
* JPA / Hibernate
* Google Gemini API
* Gradle
* Postman

## 🏗️ Architecture

```text
React Frontend
      ↓
Spring Boot REST API
      ↓
 ┌────┴─────┐
 ↓          ↓
MySQL    Gemini API
```

## 🔄 Application Flow

```text
User Login
    ↓
Enter Comment / Feedback
    ↓
REST API
    ↓
Gemini API
    ↓
Generate Response
    ↓
Save / Update Response
    ↓
MySQL
```

## 📌 Core API Operations

The backend provides REST APIs for:

* User authentication
* Creating responses
* Fetching responses
* Updating responses
* Deleting responses
* Generating AI responses

## 🚀 Getting Started

### Clone the repository

```bash
git clone https://github.com/anmolbajpai/response-generator-backend.git
cd response-generator-backend
```

### Configure Database

Configure your MySQL database and application properties:

```properties
spring.datasource.url=your_database_url
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Configure Gemini API

Add your Gemini API key through an environment variable or secure configuration.

```text
GEMINI_API_KEY=your_api_key
```

> Never commit API keys, passwords, or other sensitive credentials to GitHub.

### Run the application

Using Gradle:

```bash
gradlew.bat bootRun
```

The backend will start on the configured server port.

## 🧪 API Testing

APIs can be tested using **Postman**.

Typical flow:

```text
Login
 ↓
Submit Comment / Feedback
 ↓
Generate AI Response
 ↓
Save Response
 ↓
View / Edit / Delete Response
```

## 🔮 Future Scope

* Automatically fetch comments from social media platforms
* Automated AI response generation
* Direct response publishing
* Social media platform integrations
* Response analytics and history

## 👨‍💻 Author

**Anmol Bajpai**

* GitHub: [anmolbajpai](https://github.com/anmolbajpai)
* LinkedIn: [Anmol Bajpai](linkedin.com/in/anmolbajpai1)
* Email: [anmolbajpai164@gmail.com](mailto:anmolbajpai164@gmail.com)

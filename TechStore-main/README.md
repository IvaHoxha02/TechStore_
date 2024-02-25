# TechStore

This repository contains Java classes for managing CDs, Employees, and Users, providing functionalities such as adding, editing, removing, and retrieving data from serialized files and MongoDB.

## Table of Contents
1. [Introduction](#introduction)
2. [Object-Oriented Programming (OOP) Principles](#object-oriented-programming-oop-principles)
3. [Features](#features)
4. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#installation)
5. [MongoDB Integration](#mongodb-integration)
6. [License](#license)
7. [Acknowledgments](#acknowledgments)
8. [Usage](#usage)
   - [Example Usage](#example-usage)

## Introduction
The project includes three main classes: `AccessCd`, `AccessEmployee`, and `AccessUsers`, each responsible for managing CD, Employee, and User data, respectively. Additionally, there are supporting classes such as `CD`, `Employee`, and `User` that define the data structures.

## Object-Oriented Programming (OOP) Principles
- **Encapsulation:**
  - The classes `AccessCd`, `AccessEmployee`, `AccessUsers`, `CD`, `Employee`, and `User` encapsulate related data and behavior within their respective scopes.
  - Access to the internal state of these classes is controlled through public methods, promoting data encapsulation.
- **Inheritance:**
  - The classes `CD`, `Employee`, and `User` extend the `Serializable` interface, utilizing inheritance to inherit the serialization functionality.
- **Polymorphism:**
  - The code demonstrates polymorphism through method overloading and overriding.
- **Abstraction:**
  - The classes provide abstraction by hiding the implementation details of the underlying data structures and serialization processes.
- **Composition:**
  - The classes `AccessCd`, `AccessEmployee`, and `AccessUsers` contain instances of the corresponding data classes (`CD`, `Employee`, `User`) as part of their internal state, demonstrating composition.
- **Single Responsibility Principle (SRP):**
  - Each class has a specific responsibility.
- **Dependency Inversion Principle (DIP):**
  - The code follows DIP by relying on abstractions (e.g., `Serializable`) rather than concrete implementations.

## Features
- **CD Management:**
  - Add, edit, and remove CDs
  - Retrieve the list of CDs
- **Employee Management:**
  - Add, edit, and remove Employees
  - Retrieve the list of Employees
- **User Management:**
  - Add, edit, and remove Users
  - Check user credentials
  - Retrieve the list of Users
- **Serialization:**
  - Data is stored in serialized files (`CD.ser`, `Employee.ser`, `Users.ser`)
- **MongoDB Integration (New):**
  - Integrate MongoDB for storing and retrieving data.

## Getting Started
### Prerequisites
- JDK (Java Development Kit) installed
- IDE (Integrated Development Environment) such as IntelliJ IDEA or Eclipse

### Installation
1. Clone the repository to your local machine: `git clone https://github.com/your-username/your-repository.git`
2. Open the project in your preferred IDE.

## MongoDB Integration
To use MongoDB in your project, you need to:
- Add the MongoDB Java driver to your project dependencies.
- Configure MongoDB connection details in your application.

Example Maven dependency for MongoDB Java driver:
```xml
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongo-java-driver</artifactId>
    <version>3.12.10</version>
</dependency>
```

### License
This project is licensed under the MIT License.

### Acknowledgments
Developed by Dorina Leka & Iva Hoxha.

## Usage
The provided Java classes offer methods to interact with CD, Employee, and User data. You can integrate these classes into your Java application or use them as a reference for similar projects.

### Example Usage
```java
// Example for CD Management with MongoDB Integration
AccessCd cdManager = new AccessCd();

// Retrieve the list of CDs from MongoDB
ArrayList<CD> cdList = cdManager.getCdFromMongoDB();

// Add a new CD to MongoDB
CD newCd = new CD("Sample CD", "Rock", 19.99, 2022, 50, 1234567890, "Artist", 1);
cdManager.addCdToMongoDB(newCd);

// Remove a CD by ID from MongoDB
cdManager.rmFromMongoDB(1);

// Edit CD quantity in MongoDB
CD existingCd = // retrieve an existing CD from MongoDB;
cdManager.editCdQuantInMongoDB(100, existingCd);

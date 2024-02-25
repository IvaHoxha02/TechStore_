# TechStore

This repository contains Java classes for managing CDs, Employees, and Users, providing functionalities such as adding, editing, removing, and retrieving data from serialized files.

## Table of Contents
- [Introduction](#introduction)
- [Object-Oriented Programming (OOP) Principles](#object-oriented-programming-oop-principles)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [License](#license)
- [Acknowledgments](#acknowledgments)
- [Usage](#usage)


## Introduction
The project includes three main classes: `AccessCd`, `AccessEmployee`, and `AccessUsers`, each responsible for managing CD, Employee, and User data, respectively. Additionally, there are supporting classes such as `CD`, `Employee`, and `User` that define the data structures.

## Object-Oriented Programming (OOP) Principles
1. **Encapsulation:**
   - The classes `AccessCd`, `AccessEmployee`, `AccessUsers`, `CD`, `Employee`, and `User` encapsulate related data and behavior within their respective scopes.
   - Access to the internal state of these classes is controlled through public methods, promoting data encapsulation.
2. **Inheritance:**
   - The classes `CD`, `Employee`, and `User` extend the `Serializable` interface, utilizing inheritance to inherit the serialization functionality.
3. **Polymorphism:**
   - The code demonstrates polymorphism through method overloading and overriding.
   - For example, the `setCdQuantity` and `setCdPrice` methods in the `CD` class are overloaded to accept different parameter types.
4. **Abstraction:**
   - The classes provide abstraction by hiding the implementation details of the underlying data structures and serialization processes.
   - Public methods provide a high-level interface for interacting with the data, abstracting away the internal details.
5. **Composition:**
   - The classes `AccessCd`, `AccessEmployee`, and `AccessUsers` contain instances of the corresponding data classes (`CD`, `Employee`, `User`) as part of their internal state, demonstrating composition.
6. **Single Responsibility Principle (SRP):**
   - Each class has a specific responsibility:
     - `AccessCd` manages CD data and serialization.
     - `AccessEmployee` manages Employee data and serialization.
     - `AccessUsers` manages User data and serialization.
     - `CD`, `Employee`, and `User` represent data structures.
   - This aligns with the SRP, where each class should have only one reason to change.
7. **Dependency Inversion Principle (DIP):**
   - The code follows DIP by relying on abstractions (e.g., `Serializable`) rather than concrete implementations.
   - The code is not directly dependent on specific serialization classes but instead uses the more abstract `Serializable` interface.

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

## Getting Started
### Prerequisites
- JDK (Java Development Kit) installed
- IDE (Integrated Development Environment) such as IntelliJ IDEA or Eclipse

### Installation
1. Clone the repository to your local machine:
   git clone https://github.com/your-username/your-repository.git
2. Open the project in your preferred IDE.

### License
This project is licensed under the MIT License.

### Acknowledgments
Developed by Dorina Leka & Iva Hoxha.

## Usage
The provided Java classes offer methods to interact with CD, Employee, and User data. You can integrate these classes into your Java application or use them as a reference for similar projects.

### Example Usage
```java
// Example for CD Management
AccessCd cdManager = new AccessCd();

// Retrieve the list of CDs
ArrayList<CD> cdList = cdManager.getCd();

// Add a new CD
CD newCd = new CD("Sample CD", "Rock", 19.99, 2022, 50, 1234567890, "Artist", 1);
cdManager.addCd(newCd);

// Remove a CD by ID
cdManager.rm(1);

// Edit CD quantity
CD existingCd = // retrieve an existing CD;
cdManager.editCdQuant(100, existingCd);

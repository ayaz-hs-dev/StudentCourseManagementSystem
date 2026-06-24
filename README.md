# 🎓 Student Course Management System

<div align="center">

A desktop-based academic management system built with **Java Swing** and **Object-Oriented Programming (OOP)** principles.

Manage students, courses, instructors, enrollments, and grades through an intuitive graphical interface while maintaining persistent local storage using flat files.

![Java](https://img.shields.io/badge/Java-SE%208+-orange)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![OOP](https://img.shields.io/badge/Architecture-OOP-green)
![Status](https://img.shields.io/badge/Status-Completed-success)
![License](https://img.shields.io/badge/License-Educational-lightgrey)

</div>

---

## 📖 Overview

The **Student Course Management System** is a Java desktop application developed as an Object-Oriented Programming project. The application provides centralized management of academic records through a graphical user interface built with Java Swing.

The system supports complete CRUD operations for:

- 👨‍🎓 Students
- 📚 Courses
- 👨‍🏫 Instructors
- 📝 Enrollments
- 📊 Grades

Data is stored locally using text files, eliminating the need for an external database while maintaining persistence across sessions.

---

## ✨ Key Features

### 🔐 Authentication
- Secure administrator login
- Access control before system usage

### 👨‍🎓 Student Management
- Add new students
- Update student records
- Delete students
- View all registered students

### 📚 Course Management
- Create courses
- Manage course details
- Assign instructors
- View available courses

### 👨‍🏫 Instructor Management
- Add instructor profiles
- Update instructor information
- Manage departments and specializations

### 📝 Enrollment Management
- Enroll students into courses
- Track semester registrations
- Update enrollment records

### 📊 Grade Management
- Record Assignment Marks
- Record Midterm Marks
- Record Final Exam Marks
- Automatic Total Calculation
- Automatic Letter Grade Generation
- Automatic GPA Point Calculation

---

## 🏗️ System Architecture

The application follows a **4-Layer Architecture** that promotes maintainability and separation of concerns.

```text
┌─────────────────────┐
│      UI Layer       │
│   Java Swing GUI    │
└──────────┬──────────┘
           │
┌──────────▼──────────┐
│    Logic Layer      │
│    Manager Classes  │
└──────────┬──────────┘
           │
┌──────────▼──────────┐
│    Model Layer      │
│ Business Entities   │
└──────────┬──────────┘
           │
┌──────────▼──────────┐
│     Data Layer      │
│   File Management   │
└─────────────────────┘
```

---

## 📂 Project Structure

```text
StudentCourseManagementSystem/
│
├── model/
│   ├── Student.java
│   ├── Course.java
│   ├── Instructor.java
│   ├── Enrollment.java
│   └── Grade.java
│
├── logic/
│   ├── StudentManager.java
│   ├── CourseManager.java
│   ├── InstructorManager.java
│   ├── EnrollmentManager.java
│   └── GradeManager.java
│
├── data/
│   ├── FileManager.java
│   ├── students.txt
│   ├── courses.txt
│   ├── instructors.txt
│   ├── enrollments.txt
│   └── grades.txt
│
├── ui/
│   ├── LoginForm.java
│   ├── Dashboard.java
│   ├── BaseManagementForm.java
│   ├── StudentForm.java
│   ├── CourseForm.java
│   ├── InstructorForm.java
│   ├── EnrollmentForm.java
│   └── GradeForm.java
│
└── Main.java
```

---

## 💾 Data Persistence

The system uses **flat-file storage** for persistence.

### Storage Files

```text
students.txt
courses.txt
instructors.txt
enrollments.txt
grades.txt
```

### Example Record

```text
S001|Ali Hassan|ali@uni.edu|0300-1234567|Computer Science|2
```

---

## 🧠 OOP Concepts Implemented

| Concept | Implementation |
|----------|---------------|
| Encapsulation | Model Classes |
| Inheritance | BaseManagementForm |
| Abstraction | Manager Layer |
| Polymorphism | Method Overriding |
| Separation of Concerns | UI, Logic, Model, Data Layers |

---

## 📈 Grading System

| Marks | Grade | GPA |
|--------|--------|------|
| 85 – 100 | A | 4.0 |
| 75 – 84 | B | 3.0 |
| 65 – 74 | C | 2.0 |
| 50 – 64 | D | 1.0 |
| Below 50 | F | 0.0 |

---

## ⚙️ Installation & Setup

### Prerequisites

- Java JDK 8+
- VS Code / IntelliJ IDEA / Eclipse

### Clone Repository

```bash
git clone https://github.com/ayaz-hs-dev/StudentCourseManagementSystem.git

```

### Navigate to Project

```bash
cd StudentCourseManagementSystem
```

### Compile

```bash
javac Main.java
```

### Run

```bash
java Main
```

---

## 🚀 Future Enhancements

- Database Integration (MySQL / SQLite)
- Multi-User Authentication
- Role-Based Access Control
- Search & Filtering
- GPA Dashboard
- PDF Report Generation
- Excel Export
- CSV Import/Export
- Configuration File Support
- Unit Testing (JUnit)
- Spring Boot Web Version


---

## 📜 License

This project was developed solely for educational and academic purposes.

---

<div align="center">

⭐ If you found this project useful, consider giving it a star.

</div>

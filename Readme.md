# Library Management System (Java)

This is a simple Library Management System implemented in Java, following Object-Oriented Programming principles. It allows you to:

✅ Manage books  
✅ Manage library members (students and faculty)  
✅ Borrow and return books with borrow limits  
✅ Search books by title or author  
✅ View library statistics

---

## 📁 Project Structure

```
/YourProject
/src
  Book.java
  LibraryMember.java
  StudentMember.java
  FacultyMember.java
  BorrowLimitExceededException.java
  LibraryMemberFactory.java
  Library.java
  Main.java
/bin
Makefile
README.md
```

- All `.java` source files (except Main) are inside `/src`.
- All compiled `.class` files go into `/bin`.
- The `Main.java` file is the entry point for testing the system.

---

## 🚀 How to Build and Run

### Prerequisites

- JDK installed (Java 8 or above)
- `make` utility (Linux, macOS, or Windows with WSL/Git Bash)

---

### 1. Compile the Project

Run:

```bash
make
```

This will:

- Compile all source files from `src/` and `Main.java`
- Place compiled `.class` files in the `bin/` folder

---

### 2. Run the Project

Run:

```bash
make run
```

---

### 3. Clean Compiled Files

Remove all `.class` files with:

```bash
make clean
```

---

## 🏷 Features Implemented

- Object-Oriented Design (OOP)
    - Classes
    - Abstract classes
    - Inheritance
    - Polymorphism
    - Encapsulation
- Singleton Pattern (Library class)
- Factory Pattern (LibraryMemberFactory)
- Custom Exception (BorrowLimitExceededException)
- Collections Framework (HashMap, ArrayList)
- Java Streams and Lambdas for searching books

---

## 👥 Member Types

- **Student**
    - Max 3 books allowed
- **Faculty**
    - Max 5 books allowed

Borrowing beyond the limit triggers the custom exception `BorrowLimitExceededException`.

---

## 🔎 Search Functionality

You can search books:

- By title (partial or full)
- By author name

Results display matching books.

---

## ⚙️ How the System Works

- Add books to the library
- Add members (students or faculty) using a factory
- Members borrow and return books
- System shows library statistics:
    - Total books
    - Total borrowed books
    - Total members

---

## 📷 Sample Output

Example session when running `Main.java`:

```
Book added: Java Programming
Book added: Data Structures
Book added: Algorithms Unlocked

Member added: Sam Student
Member added: Fiona Faculty

Sam Student (Student) borrowed: Java Programming
Sam Student (Student) borrowed: Data Structures
Sam Student (Student) borrowed: Algorithms Unlocked
Student borrow limit exceeded (Max 3 books)

Fiona Faculty (Faculty) borrowed: Java Programming
Fiona Faculty (Faculty) borrowed: Data Structures

Searching for books with 'Java':
ISBN: ISBN001
Title: Java Programming
Author name: John Doe
Publication year: 2020
Available copies: 3

Searching for books by 'Alice':
ISBN: ISBN002
Title: Data Structures
Author name: Alice Smith
Publication year: 2018
Available copies: 1

Sam Student returned: Data Structures
Fiona Faculty returned: Java Programming

----- Library Statistics -----
Total books in library: 3
Total borrowed books: 2
Total members: 2
```

---

## 💻 Running Without Makefile

Alternatively, you can compile and run manually:

```bash
# Compile all source files
javac -d bin src/*.java Main.java

# Run Main class
java -cp bin Main
```

---

## 🔗 License

MIT License. Free to use and modify.

---

## ✨ Author

Created as a practice project for Java OOP and design patterns.
# Library Management System

This is a Library Management System built using Java and MySQL. It allows users to manage library books, borrow and return books, and track the borrowing history. The project demonstrates clean code principles, test-driven development, and efficient database interaction.

## Features
### 1.View Books in Library

Users can view all available books.
Shows an empty library if no books are available.

### 2.Borrow Books

Users can borrow books if available.
Reduces the book count in the library.
Deletes the book from the library if the count reaches zero.
Each user has a borrowing limit of 2 books.

### 3.Borrow Book Copies

Users can borrow a single copy of a book.
Ensures at least one copy remains in the library unless it's the last one.

###  4.Return Books

Users can return books to the library.
Updates the library stock and user’s borrowed book list.
Provides feedback when the user's borrowed list is empty.
### 5.Borrowed Book History

Displays details of borrowed books, including borrow date and return status.

## Project Structure
```
src/
├── database/
│   └── ConnectDatabase.java    # Manages database connection
├── models/
│   └── Book.java               # Represents Book entity
│   └── User.java               # Represents User entity
├── services/
│   └── BookService.java        # Business logic for managing books
│   └── BorrowService.java      # Business logic for borrowing and returning books
├── ui/
│   └── LibraryUI.java          # Main GUI
│   └── SearchBook.java         # GUI for searching books
│   └── BorrowedBooksUI.java    # GUI for viewing borrowed books
└── utils/
    └── ValidationUtil.java     # Input validation utilities
```

## Database Schema

### 1. Books Table
| Column       | Type          | Description                     |
|--------------|---------------|---------------------------------|
| `book_id`    | `INT`         | Primary key                     |
| `title`      | `VARCHAR(255)`| Book title                      |
| `author`     | `VARCHAR(255)`| Author name                     |
| `total_copies` | `INT`       | Number of copies available      |

### 2. BorrowedBooks Table
| Column        | Type          | Description                                      |
|---------------|---------------|--------------------------------------------------|
| `borrow_id`   | `INT`         | Primary key                                      |
| `user_id`     | `INT`         | Foreign key referencing `Users.user_id`          |
| `book_id`     | `INT`         | Foreign key referencing `Books.book_id`          |
| `borrowed_at` | `TIMESTAMP`   | Borrow timestamp                                 |
| `returned_at` | `TIMESTAMP`   | Return timestamp (nullable, indicates return status) |

### 3. Users Table
| Column       | Type           | Description                     |
|--------------|----------------|---------------------------------|
| `user_id`    | `INT`          | Primary key                     |
| `username`   | `VARCHAR(255)` | Username                        |
| `password`   | `VARCHAR(255)` | Encrypted password              |

## Relationships
- **Users → BorrowedBooks**: `user_id` is a foreign key.
- **Books → BorrowedBooks**: `book_id` is a foreign key.


# How to Run the Project
## Prerequisites
* ####    Java 11+
* ####    MySQL
* ####    NetBeans IDE (optional, but recommended)
* ####    Maven (for dependency management)
## Steps to Run
### 1.Clone the repository:
```
git clone https://github.com/shivUE183100/Library_managment_system.git
cd Library_managment_system
```

### 2.Import the project into your IDE.

### 3.Configure the database:

* #### Create a MySQL database.
* #### Use the following SQL script to set up the tables:
* #### sql 

```
CREATE DATABASE LibraryDB;

USE LibraryDB;

CREATE TABLE Books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    total_copies INT NOT NULL
);

CREATE TABLE BorrowedBooks (
    borrow_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    borrowed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    returned_at TIMESTAMP NULL
);

CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

```
### 3.Configure Database Connection Update ConnectDatabase.java with your MySQL credentials:

```
String url = "jdbc:mysql://localhost:3306/HexadBookLibrary";
String user = "root";
String password = "Raghvan@1998";

```

## Usage
### Viewing Books
* #### Navigate to the "Search Books" interface.
* #### Enter the book title or browse through available books.
### Borrowing Books
* #### Enter User ID and Book ID to borrow a book.
* #### The system ensures only 2 books can be borrowed at a time.
### Returning Books
* #### View borrowed books via the "Borrowed Books" interface.
* #### Select a book to return, updating the library's inventory.

## Example SQL Queries
### Add a New Book
```
INSERT INTO Books (title, author, total_copies) 
VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 3);

```
### Borrow a Book
```
INSERT INTO BorrowedBooks (user_id, book_id) 
VALUES (1, 101);

```
### Return a Book
```
UPDATE BorrowedBooks 
SET returned_at = CURRENT_TIMESTAMP 
WHERE borrow_id = 1;

```

### Remove a Book When No Copies Are Left
```
DELETE FROM Books 
WHERE book_id = 101 AND total_copies = 0;

```
## Future Enhancements
* #### Late Fees: Add a feature to calculate and display late fees.
* #### Notifications: Send reminders for due book returns.
* #### Admin Dashboard: Provide an admin interface for better management and analytics.

# Demo Library Management System

### When you run the project 
![FrontPage2](https://github.com/user-attachments/assets/5d7b5b2d-7fa3-4c1e-b784-ab0942b70847)

## login credential of Admin 
   * ### User Id :- "22525173"
   * ### Password :- "Shiv@123"
     
![adminLoginPage1](https://github.com/user-attachments/assets/469f49bf-2e45-4f2c-b4e7-5d7275dbf2cd)
### Login with invalid password and user_id of admin 
![InvalidPopMesseg3](https://github.com/user-attachments/assets/240ff37b-bd11-4ea3-a2be-046b4908a84a)
### When you click the cross button
![Exitpopup4](https://github.com/user-attachments/assets/06c15a68-db46-4346-a4ac-1db57a87871b)
### Click on user information tag
![userInfo5](https://github.com/user-attachments/assets/a8691a1f-4e9a-41af-acb0-3e74fff195ca)
### Clicked on save without entering data field
![Userinfo6](https://github.com/user-attachments/assets/a7fa2d2a-bbad-4eb9-b591-124af673e91b)
### Click on search Book tag
![searchBook7](https://github.com/user-attachments/assets/f3e01435-7658-4794-9cbe-c11604bd1352)
### Title(book name) field can't be blank
![blankTitle9](https://github.com/user-attachments/assets/b3b304f9-cf2b-43b0-a9a0-53f9774252be)
### Show pop up of available books
![BookAvailable8](https://github.com/user-attachments/assets/6bba4f1f-4a52-4631-86a3-b01ab07f5522)

### Click on borrowed Book tag
![borrowBook10](https://github.com/user-attachments/assets/b60d019a-1e34-4590-bae8-fed1553e99b0)
### Put book_id and user_id to borrow the book
![BoorwePopup11](https://github.com/user-attachments/assets/1a0a4747-b573-4323-9a4d-d2e304c1e00a)
### Click on add book tag
![addbook12](https://github.com/user-attachments/assets/a1302350-4f07-401b-b34f-ffe7fc789098)
### Fill the book details
![addBookPopup13](https://github.com/user-attachments/assets/579a209a-03a2-43fa-b2b8-e9d02cccff3d)
### When record added successfully
![recordAddedSucces20](https://github.com/user-attachments/assets/398bc54b-c233-4dff-b707-6088645cbdf0)
### Click on return book tag
![returnBook14](https://github.com/user-attachments/assets/ecbf6948-24a3-4a73-9783-0cadd41b88d4)
### Put book_id and user_id to borrow the book
![returnBookPopup15](https://github.com/user-attachments/assets/242db016-941a-48cb-8694-b9aa10439ed9)
### Click on View borrowed Book tag
![viewBorrowedrecrd_16](https://github.com/user-attachments/assets/4953e858-56ed-4a8a-ab7b-ce61a4a18ffd)
![ViewBorrowePopUp17](https://github.com/user-attachments/assets/047e93ae-72d4-454f-adda-3016b426cb6f)
### After successfully borrowed book
![borrowSuccessfully21](https://github.com/user-attachments/assets/b980916c-d772-427b-8652-b78a7d103a4c)
### Pop up when borrowed book was last book in library deleted from library
![borrowCntzeroDelete22](https://github.com/user-attachments/assets/0de68617-03a2-41e1-89b9-59fa01c16fec)
### View borrowed book data
![viewBorrowed23](https://github.com/user-attachments/assets/b2357a3a-4d76-40a7-8e6d-d63a6f71c53b)
### When you click on logout
![logout18](https://github.com/user-attachments/assets/892c3b80-a768-4c53-93be-47614d183635)















# Neighborhood Library 

This is a simple Java console application that simulates a free neighborhood library.  
The system allows users to check out and return books using an honor-based system.


## Features

-  View available books
-  Check out a book by entering your name
-  View checked out books and return them
-  Exit the program safely


## Technologies Used

- Java 17
- IntelliJ IDEA (Community Edition)
- No external libraries

## Project Structure
neighborhood-library/
├── src/
│   └── com/
│       └── pluralsight/
│           ├── LibraryApp.java
│           └── Book.java
├── screenshots/
│   
├── README.md
└── .gitignore

## Screenshots

Main Menu

<img width="1280" alt="Screenshot 2025-04-18 at 1 29 11 PM" src="https://github.com/user-attachments/assets/c3b4377b-a095-477a-b78e-2af6a6a9fb2e" />


Show Available Books

<img width="1280" alt="Screenshot 2025-04-18 at 1 29 45 PM" src="https://github.com/user-attachments/assets/254a1e9a-4153-420a-9fd0-5c4a1e01b635" />

<img width="1280" alt="Screenshot 2025-04-18 at 1 29 59 PM" src="https://github.com/user-attachments/assets/0cb56d73-e93c-4fbc-a8a9-0950dc67b730" />


Checking Out a Book

<img width="1280" alt="Screenshot 2025-04-18 at 1 30 45 PM" src="https://github.com/user-attachments/assets/ab2f2862-5583-4407-9601-bca888576854" />


Successfully Checked Out

<img width="1280" alt="Screenshot 2025-04-18 at 1 30 59 PM" src="https://github.com/user-attachments/assets/c8d01249-5b80-4071-b883-e7faf3299b5d" />


Show Checked Out Books

<img width="1280" alt="Screenshot 2025-04-18 at 1 32 15 PM" src="https://github.com/user-attachments/assets/8efb33dd-58e1-44c0-bd57-88e6235ba09b" />

Interesting Code Snippet

```java
public void checkOut(String name) {
    this.isCheckedOut = true;
    this.checkedOutTo = name;
}
Why it's interesting:
This method represents the key idea of an honor-based checkout system. It updates the book status and tracks who has borrowed it.


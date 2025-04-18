package com.pluralsight;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = createInventory(); // 20 kitaplık envanter oluştur

        boolean running = true;
        while (running) {
            System.out.println("\n=== Neighborhood Library ===");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    showAvailableBooks(books, scanner);
                    break;
                case "2":
                    showCheckedOutBooks(books, scanner);
                    break;
                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    // 📚 Envanterde 20 kitap oluştur
    public static Book[] createInventory() {
        Book[] books = new Book[20];
        books[0] = new Book(1, "9780140449136", "The Odyssey");
        books[1] = new Book(2, "9780061120084", "To Kill a Mockingbird");
        books[2] = new Book(3, "9780451524935", "1984");
        books[3] = new Book(4, "9780141439600", "Pride and Prejudice");
        books[4] = new Book(5, "9780743273565", "The Great Gatsby");
        books[5] = new Book(6, "9780141182803", "Brave New World");
        books[6] = new Book(7, "9780142437230", "Moby-Dick");
        books[7] = new Book(8, "9780385472579", "Zen and the Art of Motorcycle Maintenance");
        books[8] = new Book(9, "9780307277671", "The Road");
        books[9] = new Book(10, "9780679783268", "The Catcher in the Rye");
        books[10] = new Book(11, "9780743482745", "Hamlet");
        books[11] = new Book(12, "9780316769488", "Franny and Zooey");
        books[12] = new Book(13, "9780060850524", "Of Mice and Men");
        books[13] = new Book(14, "9780553212419", "The Scarlet Letter");
        books[14] = new Book(15, "9780743477123", "Macbeth");
        books[15] = new Book(16, "9780143039433", "Crime and Punishment");
        books[16] = new Book(17, "9780199535569", "Jane Eyre");
        books[17] = new Book(18, "9780486280615", "Dracula");
        books[18] = new Book(19, "9780140449266", "The Divine Comedy");
        books[19] = new Book(20, "9780679734529", "Beloved");
        return books;
    }

    // ✅ Ödünç alınabilir kitapları göster ve işlem yap
    public static void showAvailableBooks(Book[] books, Scanner scanner) {
        System.out.println("\n--- Available Books ---");
        boolean anyAvailable = false;

        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle());
                anyAvailable = true;
            }
        }

        if (!anyAvailable) {
            System.out.println("No available books.");
            return;
        }

        System.out.print("\nEnter the ID of the book you want to check out (or X to return): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("x")) {
            return;
        }

        try {
            int id = Integer.parseInt(input);
            for (Book book : books) {
                if (book.getId() == id && !book.isCheckedOut()) {
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    book.checkOut(name);
                    System.out.println("Book checked out successfully to " + name + ".");
                    return;
                }
            }
            System.out.println("Book not found or already checked out.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    // ✅ Ödünç alınmış kitapları göster ve iade et
    public static void showCheckedOutBooks(Book[] books, Scanner scanner) {
        System.out.println("\n--- Checked Out Books ---");
        boolean anyCheckedOut = false;

        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d | ISBN: %s | Title: %s | Checked out to: %s%n",
                        book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                anyCheckedOut = true;
            }
        }

        if (!anyCheckedOut) {
            System.out.println("No books are currently checked out.");
            return;
        }

        System.out.print("\nEnter C to check in a book, or X to return to the main menu: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("x")) {
            return;
        } else if (input.equalsIgnoreCase("c")) {
            System.out.print("Enter the ID of the book to check in: ");
            String idInput = scanner.nextLine();
            try {
                int id = Integer.parseInt(idInput);
                for (Book book : books) {
                    if (book.getId() == id && book.isCheckedOut()) {
                        book.checkIn();
                        System.out.println("Book has been successfully checked in.");
                        return;
                    }
                }
                System.out.println("Book not found or it’s not checked out.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format.");
            }
        } else {
            System.out.println("Invalid option.");
        }
    }
}
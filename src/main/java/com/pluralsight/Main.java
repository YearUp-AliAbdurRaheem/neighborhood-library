package com.pluralsight;

import java.util.Arrays;

public class Main {

    public static Book[] Library;

    public static void main(String[] args) {
        Library = getInitializedLibrary();

        // Main Loop
        do {
            // Updates filtered arrays
            Book[] bookByAvailability = Arrays.stream(Library).filter(book -> !book.isCheckedOut()).toArray(Book[]::new);
            Book[] bookByCheckedOut = Arrays.stream(Library).filter(Book::isCheckedOut).toArray(Book[]::new);
            // Main Screen
            char option = MainScreen();
            switch (option) {
                case 'A':
                    // Take all Books where Book.getCheckoutOutTo == true
                    DisplayBooks(bookByAvailability);
                    char bookScreenOption = AvailableBookScreen(); // next screen
                    switch (bookScreenOption) {
                        case 'C':
                            CheckOutScreen(true); // The true means your checking OUT a book
                            continue;
                        case 'X':
                            continue;
                    }

                case 'C':
                    DisplayBooks(bookByCheckedOut);
                    if (bookByCheckedOut.length == 0) {continue;} // If there are no checked out books dont show the checkin screen
                    char UNBookScreenOption = UnAvailableBookScreen();
                    switch (UNBookScreenOption) {
                        case 'C':
                            CheckOutScreen(false); // The false means your checking IN a book
                            continue;
                        case 'X':
                            continue;
                    }

                case 'X':
                    return;


            }
        } while (true);
    }

    public static char MainScreen() {
        System.out.println("Welcome to the Library!  Please select from the following choices:");
        System.out.println("    Show [A]vailable Books");
        System.out.println("    Show [C]hecked Out Books");
        System.out.println("    E[X]it the Library");

        do{

            System.out.print("Command [A, C, X]: ");
            String command = Console.PromptForString();

            switch (command.toUpperCase()) {
                case "A":
                    return 'A';
                case "C":
                    return 'C';
                case "X", "EXIT", "Q", "QUIT":
                    return 'X';
                default:
                    System.out.println("command not found: " + command.toUpperCase());
            }
        }  while (true);


    }


    public static char AvailableBookScreen() {
        System.out.println("    [C]heckOut a Book");
        System.out.println("    E[X]it to Main Screen");

        do{

            System.out.print("Command [C, X]: ");
            String command = Console.PromptForString();

            switch (command.toUpperCase()) {
                case "C":
                    return 'C';
                case "X", "EXIT", "Q", "QUIT":
                    return 'X';
                default:
                    System.out.println("command not found: " + command.toUpperCase());
            }
        }  while (true);
    }
    public static char UnAvailableBookScreen() {
        System.out.println("    [C]heckIN a Book");
        System.out.println("    E[X]it to Main Screen");

        do{

            System.out.print("Command [C, X]: ");
            String command = Console.PromptForString();

            switch (command.toUpperCase()) {
                case "C":
                    return 'C';
                case "X", "EXIT", "Q", "QUIT":
                    return 'X';
                default:
                    System.out.println("command not found: " + command.toUpperCase());
            }
        }  while (true);
    }

    public static void CheckOutScreen(boolean out) {
        do {
            byte bookID = Console.PromptForByte("Enter Book ID: "); // get id from user
            if (bookID == 0 //check if id is valid
                    || bookID > Library.length
                    || (out ? Library[bookID -1].isCheckedOut() : ! Library[bookID -1].isCheckedOut())) { // the check is diferent weather the user is checking in or out a book, hence the turnery operator
                System.out.println("Invalid ID");
                continue;
            }
            if (out) {
                Console.scanner.nextLine();
                String name = Console.PromptForString("Enter your name: ");
                Library[bookID -1].checkOut(name);
                return;
            }
            Console.scanner.nextLine();
            Library[bookID -1].checkIn();
            return;
        } while (true);
    }



    public static void DisplayBooks(Book[] books) {
        System.out.printf("%5s %55s %20s %24s\n", "ID", "TITLE", "ISBN", "CHECKOUT OUT TO");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for (Book book : books) {
            System.out.printf("%5s %55s %20s %24s\n", book.getId(), book.getTitle(), book.getIsbn(), book.getCheckoutOutTo());
        }
    }



    public static Book[] getInitializedLibrary() {
        Book[] library = new Book[20];
        library[0] = new Book(1, "Practical Tableau", "ISBN11332211");
        library[1] = new Book(2, "Pro Git", "ISBN1133229918");
        library[2] = new Book(3, "Genetic Programming", "ISBN2299220202");
        library[3] = new Book(4, "Clean Code", "ISBN9780136083238");
        library[4] = new Book(5, "Design Patterns", "ISBN9780201633610");
        library[5] = new Book(6, "Effective Java", "ISBN9780134686097");
        library[6] = new Book(7, "Java Concurrency in Practice", "ISBN9780321349606");
        library[7] = new Book(8, "The Pragmatic Programmer", "ISBN9780135957059");
        library[8] = new Book(9, "Introduction to the Theory of Computation", "ISBN9781133187790");
        library[9] = new Book(10, "Artificial Intelligence: A Modern Approach", "ISBN9780134610993");
        library[10] = new Book(11, "The Art of Computer Programming", "ISBN9780201896831");
        library[11] = new Book(12, "Python Crash Course", "ISBN9781593279288");
        library[12] = new Book(13, "The Clean Coder", "ISBN9780136083238");
        library[13] = new Book(14, "Code Complete", "ISBN9780735619678");
        library[14] = new Book(15, "Refactoring: Improving the Design of Existing Code", "ISBN9780134757599");
        library[15] = new Book(16, "Head First Design Patterns", "ISBN9780596007126");
        library[16] = new Book(17, "You Don't Know JS", "ISBN9781491950357");
        library[17] = new Book(18, "The Mythical Man-Month", "ISBN9780201835953");
        library[18] = new Book(19, "Learning JavaScript Data Structures and Algorithms", "ISBN9781785880332");
        library[19] = new Book(20, "The Elements of Programming Interviews", "ISBN9781512218237");
        return library;
    }
}
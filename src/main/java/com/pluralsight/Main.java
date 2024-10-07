package com.pluralsight;

public class Main {

    public static Book[] Library;

    public static void main(String[] args) {
        Library = getInitializedLibrary();

        char option = PromptMainChoices();
        switch (option) {
            case 'A':

        }
    }

    public static char PromptMainChoices(){
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
                case "X":
                case "EXIT":
                case "Q":
                case "QUIT":
                    return 'X';
                default:
                    System.out.println("command not found: " + command.toUpperCase());
            }
        }  while (true);


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
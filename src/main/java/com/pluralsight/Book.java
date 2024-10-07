package com.pluralsight;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkoutOutTo;

    public Book(int id, String title, String isbn) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;

        this.isCheckedOut = false;
        this.checkoutOutTo = "";
    }
    // Getters
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckoutOutTo() {
        return checkoutOutTo;
    }

    public void checkOut(String name) {
        this.checkoutOutTo = name;
        this.isCheckedOut = true;
    }

    public void checkIn() {
        this.checkoutOutTo = "";
        this.isCheckedOut = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkoutOut='" + checkoutOutTo + '\'' +
                '}';
    }
}

package com.twu.biblioteca;


public class Checkout {
    private static final String SUCCESSFUL_MESSAGE = "Thank you! Enjoy the book";

    public String checkout(Book book) {
        book.changeToOnLoan();
        return SUCCESSFUL_MESSAGE;
    }

    public String successMessage() {
        return SUCCESSFUL_MESSAGE;
    }
}

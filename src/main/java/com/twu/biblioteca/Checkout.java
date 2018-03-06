package com.twu.biblioteca;


public class Checkout {
    private static final String SUCCESSFUL_MESSAGE = "Thank you! Enjoy the book.";
    private static final String UNSUCCESSFUL_MESSAGE = "That book is not available.";

    public String checkout(Book book) {
        if (!book.onLoan()) {
            book.changeToOnLoan();
            return SUCCESSFUL_MESSAGE;
        }
        return UNSUCCESSFUL_MESSAGE;
    }

    public String successMessage() {
        return SUCCESSFUL_MESSAGE;
    }

    public String unsuccessfulMessage() {
        return UNSUCCESSFUL_MESSAGE;
    }
}

package com.twu.biblioteca;


public class Checkout {
    private static final String SUCCESSFUL_MESSAGE = "Thank you! Enjoy the book.";
    private static final String UNSUCCESSFUL_MESSAGE = "That book is not available.";
    private static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book.";
    private static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.";

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

    public String checkin(Book book) {
        if (book.onLoan()) {
            book.changeToReturned();
            return SUCCESSFUL_RETURN_MESSAGE;
        }
        return UNSUCCESSFUL_RETURN_MESSAGE;
    }

    public String successReturnMessage() {
        return SUCCESSFUL_RETURN_MESSAGE;
    }

    public String unsuccessfulReturnMessage() {
        return UNSUCCESSFUL_RETURN_MESSAGE;
    }
}

package com.twu.biblioteca;


import com.twu.biblioteca.items.Item;

public class Checkout {
    public static final String SUCCESSFUL_MESSAGE = "Thank you! Enjoy the book.";
    public static final String UNSUCCESSFUL_MESSAGE = "That book is not available.";
    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book.";
    public static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.";

    public String checkout(Item item) {
        if (!item.onLoan()) {
            item.changeToOnLoan();
            return SUCCESSFUL_MESSAGE;
        }
        return UNSUCCESSFUL_MESSAGE;
    }

    public String checkin(Item item) {
        if (item.onLoan()) {
            item.changeToReturned();
            return SUCCESSFUL_RETURN_MESSAGE;
        }
        return UNSUCCESSFUL_RETURN_MESSAGE;
    }

}

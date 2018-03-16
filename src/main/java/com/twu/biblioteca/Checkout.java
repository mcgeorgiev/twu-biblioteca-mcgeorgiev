package main.java.com.twu.biblioteca;


public class Checkout {
    public static final String SUCCESSFUL_MESSAGE = "Thank you! Enjoy the book.";
    public static final String UNSUCCESSFUL_MESSAGE = "That book is not available.";
    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book.";
    public static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.";

    public String checkout(Book book) {
        if (!book.onLoan()) {
            book.changeToOnLoan();
            return SUCCESSFUL_MESSAGE;
        }
        return UNSUCCESSFUL_MESSAGE;
    }

    public String checkin(Book book) {
        if (book.onLoan()) {
            book.changeToReturned();
            return SUCCESSFUL_RETURN_MESSAGE;
        }
        return UNSUCCESSFUL_RETURN_MESSAGE;
    }

}

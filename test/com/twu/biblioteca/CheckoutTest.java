package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CheckoutTest {
    Book book;
    Checkout co;
    Movie movie;

    @Before
    public void init() {
        book = new Book("Thomas Hardy", "The Return of the Native", "1878");
        movie = new Movie("Falling Down", "1993", "Joel Schumacher", "10");
        co = new Checkout();
    }

    @Test
    public void movieCheckedOut() {
        co.checkout(movie);
        assertTrue(movie.onLoan());
    }


    @Test
    public void bookCheckedOut() {
       co.checkout(book);
       assertTrue(book.onLoan());
    }

    @Test
    public void successfulCheckout() {
        checkout(Checkout.SUCCESSFUL_MESSAGE);
    }

    @Test
    public void unsuccessfulCheckout() {
        book.changeToOnLoan();
        checkout(Checkout.UNSUCCESSFUL_MESSAGE);
    }

    @Test
    public void returnBook() {
        returnItem(book);
    }

    @Test
    public void returnMovie() {
        returnItem(movie);
    }
    
    public void returnItem(Item item) {
        co.checkout(book);
        assertTrue(book.onLoan());
        co.checkin(book);
        assertFalse(book.onLoan());
    }




    @Test
    public void successfulReturn() {
        book.changeToOnLoan();
        String message = co.checkin(book);
        assertEquals(Checkout.SUCCESSFUL_RETURN_MESSAGE, message);
    }

    @Test
    public void unsuccessfulReturn() {
        String message = co.checkin(book);
        assertEquals(Checkout.UNSUCCESSFUL_RETURN_MESSAGE, message);
    }

    private void checkout(String correctMessage) {
        String testMessage = co.checkout(book);
        assertEquals(correctMessage, testMessage);
    }


}

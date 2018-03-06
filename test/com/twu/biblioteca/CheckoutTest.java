package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CheckoutTest {
    Book book;
    Checkout co;

    @Before
    public void init() {
        book = new Book("Thomas Hardy", "The Return of the Native", "1878");
        co = new Checkout();
    }

    @Test
    public void bookCheckedOut() {
       co.checkout(book);
       assertTrue(book.onLoan());
    }

    @Test
    public void successfulCheckout() {
        String message = co.checkout(book);
        assertEquals(co.successMessage(), message);
    }

    @Test
    public void unsuccessfulCheckout() {
        book.changeToOnLoan();
        String message = co.checkout(book);
        assertEquals(co.unsuccessfulMessage(), message);
    }

    @Test
    public void returnBook() {
        co.checkout(book);
        assertTrue(book.onLoan());
        co.checkin(book);
        assertFalse(book.onLoan());
    }


    @Test
    public void successfulReturn() {
        book.changeToOnLoan();
        String message = co.checkin(book);
        assertEquals(co.successReturnMessage(), message);
    }

    @Test
    public void unsuccessfulReturn() {
        String message = co.checkin(book);
        assertEquals(co.unsuccessfulReturnMessage(), message);
    }


}

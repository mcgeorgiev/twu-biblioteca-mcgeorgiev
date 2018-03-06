package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class BookTest {
    Book book;
    @Before
    public void init() {
        book = new Book("Thomas Hardy", "The Return of the Native", "1878");
    }

    @Test
    public void showBookDetail() {
        assertEquals(String.format("%20s | %20s | %4s", "Thomas Hardy", "The Return of the Native", "1878"), book.getDetail());
    }

    @Test
    public void bookIsCheckedOut() {
        assertFalse(book.onLoan());
    }
}

package com.twu.biblioteca;

import main.java.com.twu.biblioteca.Item;
import main.java.com.twu.biblioteca.Movie;
import main.java.com.twu.biblioteca.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ItemTest  {

    @Test
    public void itemAcceptsMovie() {
        Item movie = new Movie("Falling Down", "1993", "Joel Schumacher", "10");
        assertEquals("Falling Down 1993 Joel Schumacher 10", movie.getDetail());
    }

    @Test
    public void itemAcceptsBook() {
        Item book = new Book("Thomas Hardy", "The Return of the Native", "1878");
        assertEquals(String.format(book.getFormatString(), "Thomas Hardy", "The Return of the Native", "1878"), book.getDetail());
    }

    @Test
    public void bookIsCheckedOut() {
        Item book = new Book("Thomas Hardy", "The Return of the Native", "1878");
        assertFalse(book.onLoan());
    }
}

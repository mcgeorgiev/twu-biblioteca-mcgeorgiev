package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ItemTest  {
    @Test
    public void itemAcceptsMovie() {
        Item movie = new Movie(MovieData.TITLE, MovieData.YEAR, MovieData.DIRECTOR, MovieData.RATING);
        assertEquals(String.format(movie.getFormatString(), MovieData.TITLE, MovieData.YEAR, MovieData.DIRECTOR, MovieData.RATING), movie.getDetail());
    }

    @Test
    public void itemAcceptsBook() {
        Item book = new Book(BookData.TITLE, BookData.AUTHOR, BookData.YEAR);
        assertEquals(String.format(book.getFormatString(), BookData.TITLE, BookData.AUTHOR, BookData.YEAR), book.getDetail());
    }

    @Test
    public void bookIsCheckedOut() {
        Item book = new Book(BookData.TITLE, BookData.AUTHOR, BookData.YEAR);
        assertFalse(book.onLoan());
    }
}

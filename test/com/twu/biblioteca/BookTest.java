package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BookTest {
    @Test
    public void showBookDetail() {
        Book book = new Book("Thomas Hardy", "The Return of the Native", "1878");
        assertEquals(String.format("%20s | %20s | %4s", "Thomas Hardy", "The Return of the Native", "1878"), book.getDetail());
    }
}

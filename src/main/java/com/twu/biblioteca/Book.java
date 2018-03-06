package com.twu.biblioteca;

public class Book {
    private String title, author;
    private String dop;

    public Book(String t, String a, String d) {
        title = t;
        author = a;
        dop = d;
    }

    public String getDetail() {
        return String.format("%20s | %20s | %4s", title, author, dop);
    }
}

package com.twu.biblioteca;

public class Book {
    private String title, author;
    private String dop;
    private boolean onLoan;

    public Book(String t, String a, String d) {
        title = t;
        author = a;
        dop = d;
        onLoan = false;
    }

    public String getDetail() {
        return String.format("%30s | %30s | %4s", title, author, dop);
    }

    public boolean onLoan() {
        return onLoan;
    }

    public void changeToOnLoan() {
        onLoan = true;
    }

    public void changeToReturned() {
        onLoan = false;
    }
}

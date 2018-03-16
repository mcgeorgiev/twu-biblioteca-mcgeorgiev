package com.twu.biblioteca;

public class Book extends Item {
    private String title, author, dop;

    public Book(String t, String a, String d) {
        title = t;
        author = a;
        dop = d;
        onLoan = false;
        formatString = "%20s | %20s | %4s";
    }

    public String getDetail() {
        return String.format("%20s | %20s | %4s", title, author, dop);
    }



}

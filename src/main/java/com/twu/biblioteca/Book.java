package com.twu.biblioteca;

public class Book extends Item {
    private String title, author, dop;

    public Book(String t, String a, String d) {
        title = t;
        author = a;
        dop = d;
        onLoan = false;
        formatString = "%30s | %30s | %4s";
    }

    public String getDetail() {
        return String.format(formatString, title, author, dop);
    }



}

package com.twu.biblioteca;

public class Movie extends Item {
    private String title, year, director, rating;

    public Movie(String t, String y, String d, String r) {
        title = t;
        year = y;
        director = d;
        rating = r;
        formatString = "%s %s %s %s";

    }

    public String getDetail() {
        return String.format(formatString, title, year, director, rating);
    }
}

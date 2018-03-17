package com.twu.biblioteca;

public abstract class Item {
    protected String title;
    protected boolean onLoan;
    protected String formatString;

    public String getDetail() {
        return "";
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

    public String getFormatString() {
        return formatString;
    }

    public String getTitle() { return title; }
}

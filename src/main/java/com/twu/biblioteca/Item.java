package main.java.com.twu.biblioteca;

public abstract class Item {
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
}

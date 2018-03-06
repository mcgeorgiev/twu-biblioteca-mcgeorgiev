package com.twu.biblioteca;

public class ListBooksCommand extends Command {
    private String message;

    public ListBooksCommand() {
        super.identifier = "l";
    }

    public void execute() {
        message();
    }

    public void message() {
        System.out.println(getMessage());
    }

    public String getMessage() {
        return "Listing Books";
    }

}
package com.twu.biblioteca;

public class QuitCommand extends Command {
    private String message;

    public QuitCommand() {
        super.identifier = "q";
    }

    public void execute() {
        message();
    }

    public void message() {
        System.out.println(getMessage());
    }

    public String getMessage() {
        return "Thank you for using Biblioteca.";
    }

}

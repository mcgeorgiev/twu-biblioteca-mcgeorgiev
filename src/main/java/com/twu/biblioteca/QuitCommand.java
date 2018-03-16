package com.twu.biblioteca;

public class QuitCommand extends Command {

    public QuitCommand() {
        super.message = "Thank you for using Biblioteca.";
        super.description = "Quit Biblioteca";
    }

    public void execute() {
        message();
        System.exit(0);
    }

}

package com.twu.biblioteca;


public abstract class Command {
    protected String message;
    protected String description;

    public Command() {
    }

    public abstract void execute();

    public String getMessage(){
        return message + "\n";
    }

    public String description() {
        return description;
    }

    public void message() {
        System.out.println(getMessage());
    }
}

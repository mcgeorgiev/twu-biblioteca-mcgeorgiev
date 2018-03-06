package com.twu.biblioteca;

import java.util.List;

public abstract class Command {
    protected String message;
    protected String description;

    public Command() {
    }

    public abstract void execute(List<Book> items);

    public String getMessage(){
        return message + "\n";
    }

    public String description() {
        return description;
    }
}

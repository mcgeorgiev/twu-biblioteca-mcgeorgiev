package com.twu.biblioteca;

import java.util.List;

public abstract class Command {
    protected String message;

    public Command() {
    }

    public void execute(List<Book> items){}

    public String getMessage(){
        return message + "\n";
    }

}

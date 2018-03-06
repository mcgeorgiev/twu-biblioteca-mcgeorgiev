package com.twu.biblioteca;

public abstract class Command {
    protected String identifier;

    public Command() {
    }

    public void execute(){}

    public boolean compareID(String id) {
        return (id.equals(identifier)) ? true : false;
    }

}

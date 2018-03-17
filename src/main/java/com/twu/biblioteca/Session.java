package com.twu.biblioteca;

public class Session {
    private User currentUser;
    public Session() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean loggedIn() {
        return true ? currentUser != null : false;
    }

    public void setCurrentUser(User newUser) {
        currentUser = newUser;
    }
}
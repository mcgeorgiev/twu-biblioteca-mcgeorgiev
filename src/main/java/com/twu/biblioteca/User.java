package com.twu.biblioteca;

public class User {
    private String libraryNumber, password;
    private boolean loggedIn;
    public User(String l, String p) {
        libraryNumber = l;
        password = p;
        loggedIn = false;
    }

    public boolean verifyPassword(String pwd) {
        return password.equals(pwd);
    }

    public boolean verify(String ln, String pwd) {
        return (verifyLibraryNumber(ln) && verifyPassword(pwd));
    }

    public boolean verifyLibraryNumber(String ln) {
        return libraryNumber.equals(ln);
    }

    public void login() {
        loggedIn = true;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}

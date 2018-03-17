package com.twu.biblioteca;

public class User {
    private String libraryNumber, password, name, email, phoneNumber;
    public User(String l, String p) {
        libraryNumber = l;
        password = p;
        name = "";
        email = "";
        phoneNumber = "";
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

    public String getAccountInformation() {
        return String.format("%s %s %s", name, email, phoneNumber);
    }

    public void setAccountInformation(String n, String e, String p) {
        name = n;
        email = e;
        phoneNumber = p;
    }
}

package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class LoginCommand extends Command {
    Scanner input = new Scanner(System.in);
    List<User> users;
    Session session;

    public LoginCommand(List<User> u, Session sess) {
        users = u;
        session = sess;
        super.description = "Login";
    }

    public void execute() {
        System.out.println("Enter Your Library Number: xxx-xxxx");
        String libraryNumber = input.next();

        System.out.println("Enter Your Password");
        String password = input.next();

        if (login(libraryNumber, password)) {

            System.out.println("Logged In Successfully");
        } else {
            System.out.println("Incorrect Credentials");
        }

    }

    public boolean login(String libraryNumber, String password) {
        for (User u: users) {
            if (u.verify(libraryNumber, password)) {
                session.setCurrentUser(u);
                return true;
            }
        }
        return false;
    }
}

package com.twu.biblioteca;

public class InfoCommand extends Command {
    Session session;
    public InfoCommand( Session sess) {
        session = sess;
        super.description = "Get User Info";
    }

    public void execute() {
        if (session.getCurrentUser() != null) {
            System.out.println(session.getCurrentUser().getAccountInformation());
        } else {
            System.out.println("Please Login First");
        }
    }
}

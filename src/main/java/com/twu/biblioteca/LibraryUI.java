package com.twu.biblioteca;

import java.util.*;

public class LibraryUI {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";
    private static final String MENU_MESSAGE = "Please select an option.";
    private static final String BO0K_LIST_MESSAGE = "Listing books";
    private static final String NO_COMMAND = "No Command found";

    private Scanner input = new Scanner(System.in);

    private static Map<String, Command> commands = new HashMap<String, Command>() {{
        put("q", new QuitCommand());
        put("l", new ListBooksCommand());
    }};

    public void introMessages() {
        System.out.println(welcomeMessage());
        System.out.println(menuMessage());
    }

    public class Pair {
        private String key;
        private Command value;
        public Pair(String k, Command v) {
            key = k;
            value = v;
        }
        public String getKey() {return key;}
        public Command getValue() {return value;}
        public boolean compareKey(String k) {return key.equals(k);}
    }

    private void run() {

        Pair cmd = getCommandFromInput();

        while(!(cmd.compareKey("q"))) {
            execute(cmd.getValue());
            cmd = getCommandFromInput();
        }
        execute(cmd.getValue());

    }

    private void execute(Command cmd) {
        if (cmd != null) {
            cmd.execute();
        } else {
            System.out.println(NO_COMMAND);
        }
    }

    private Pair getCommandFromInput() {
        return new Pair(input.next(), commands.get(input.next()));
    }

    public String welcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public String menuMessage() {
        return MENU_MESSAGE;
    }


    public static void main(String[] args) {
        LibraryUI lib = new LibraryUI();
        lib.introMessages();
        lib.run();
    }
}
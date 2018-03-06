package com.twu.biblioteca;

import java.util.*;

public class LibraryUI {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";
    private static final String MENU_MESSAGE = "Please select an option.";
    private static final String BO0K_LIST_MESSAGE = "Listing books";
    private static final String NO_COMMAND = "No Command found";

    private Scanner input = new Scanner(System.in);

    private Map<String, Command> commands = new HashMap<String, Command>() {{
        put("q", new QuitCommand());
        put("l", new ListBooksCommand());
    }};

    private List<Book> books = new ArrayList<Book>() {{
        add(new Book("Thomas Hardy", "The Return of the Native", "1878"));
        add(new Book("Adam Tooze", "The Deluge", "2015"));
        add(new Book("Andrew Michael Hurley", "The Loney", "2015"));
        Book loaned = new Book("John Kennedy Toole", "A Confederacy of Dunces", "1980");
        loaned.changeToOnLoan();
        add(loaned);
    }};

    public void introMessages() {
        System.out.println(welcomeMessage());
        System.out.println(menuMessage());
    }

    public Command getCommand(String id) {
        return commands.get(id);
    }

    public void execute(Command cmd) {
        if (cmd != null) {
            cmd.execute(books);
        } else {
            System.out.println(NO_COMMAND);
        }
    }

    public void run() {
        while (true) {
            execute(getCommand(getInput()));
        }
    }

    public String getInput() {
        return input.next();
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

    public String getBooks() {
        StringBuilder listOfBooks = new StringBuilder();
        for (Book b :books) {
            if (!b.onLoan()) {
                listOfBooks.append(b.getDetail());
                listOfBooks.append("\n");
            }
        }
        return listOfBooks.toString()+"\n";
    }
}
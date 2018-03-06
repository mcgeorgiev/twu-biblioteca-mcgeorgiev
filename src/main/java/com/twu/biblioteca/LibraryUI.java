package com.twu.biblioteca;

import java.util.*;

public class LibraryUI {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";
    public static final String MENU_MESSAGE = "Please select an option.";
    public static final String NO_COMMAND = "Select a valid option!";

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
        System.out.println(WELCOME_MESSAGE);
        System.out.println(MENU_MESSAGE);
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
        System.out.println(printSelectionOptions());

        while (true) {
            execute(getCommand(getInput()));
        }
    }

    public String getInput() {
        return input.next();
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

    public String printSelectionOptions() {
        StringBuilder selections = new StringBuilder();
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            selections.append(String.format("%4s : %20s\n", entry.getKey(), entry.getValue().description()));
        }
        return selections.toString();

    }
}
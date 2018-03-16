package com.twu.biblioteca;

import java.util.*;

public class LibraryUI {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca!";
    public static final String MENU_MESSAGE = "Please select an option.";
    public static final String NO_COMMAND = "Select a valid option!";

    private Scanner input = new Scanner(System.in);

    private List<Item> books = new ArrayList<Item>() {{
        add(new Book("Thomas Hardy", "The Return of the Native", "1878"));
        add(new Book("Adam Tooze", "The Deluge", "2015"));
        add(new Book("Andrew Michael Hurley", "The Loney", "2015"));
        Book loaned = new Book("John Kennedy Toole", "A Confederacy of Dunces", "1980");
        loaned.changeToOnLoan();
        add(loaned);
    }};

    private List<Item> movies = new ArrayList<Item>() {{
        add(new Movie("Falling Down", "1993", "Joel Schumacher", "10"));
        add(new Movie("The Killing Fields", "Roland Joffé", "1984", "9"));
        add(new Movie("Brazil", "1985", "Terry Gilliam", "Unrated"));
//        Book loaned = new Book("John Kennedy Toole", "A Confederacy of Dunces", "1980");
//        loaned.changeToOnLoan();
//        add(loaned);
    }};

    private Map<String, Command> commands = new HashMap<String, Command>() {{
        put("q", new QuitCommand());
        put("l", new ListBooksCommand(books));
        put("m", new ListMoviesCommand(movies));
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
            cmd.execute();
        } else {
            System.out.println(NO_COMMAND);
        }
    }

    private void run() {
        System.out.println(printSelectionOptions());

        while (true) {
            execute(getCommand(getInput()));
        }
    }

    private String getInput() {
        return input.next();
    }

    public String getBooks() {
        return getItems(books);
    }

    public String getMovies() {
        return getItems(movies);
    }

    private String getItems(List<Item> items) {
        StringBuilder listOfBooks = new StringBuilder();
        for (Item i :items) {
            if (!i.onLoan()) {
                listOfBooks.append(i.getDetail());
                listOfBooks.append("\n");
            }
        }
        return listOfBooks.toString()+"\n";
    }

    private String printSelectionOptions() {
        StringBuilder selections = new StringBuilder();
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            selections.append(String.format("%4s : %20s\n", entry.getKey(), entry.getValue().description()));
        }
        return selections.toString();
    }

    public static void main(String[] args) {
        LibraryUI lib = new LibraryUI();
        lib.introMessages();
        lib.run();
    }
}
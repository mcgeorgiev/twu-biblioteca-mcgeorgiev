package com.twu.biblioteca;
import java.util.List;

public class ListMoviesCommand extends Command {
    private List<Item> movies;

    public ListMoviesCommand(List<Item> movies) {
        this.movies = movies;
        super.message = "Listing Movies";
        super.description = "List present movies";
    }

    public void execute() {
        message();
        StringBuilder listOfBooks = new StringBuilder();
        for (Item m :this.movies) {
            if (!m.onLoan()) {
                listOfBooks.append(m.getDetail());
                listOfBooks.append("\n");
            }
        }
        System.out.println(listOfBooks);
    }

}


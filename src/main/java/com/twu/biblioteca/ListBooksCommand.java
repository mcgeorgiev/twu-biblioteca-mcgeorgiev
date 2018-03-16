package com.twu.biblioteca;

import java.util.List;

public class ListBooksCommand extends Command {
    private List<Item> books;

    public ListBooksCommand(List<Item> books) {
        this.books = books;
        super.message = "Listing Books";
        super.description = "List present books";
    }

    public void execute() {
        message();
        StringBuilder listOfBooks = new StringBuilder();
        for (Item b :this.books) {
            if (!b.onLoan()) {
                listOfBooks.append(b.getDetail());
                listOfBooks.append("\n");
            }
        }
        System.out.println(listOfBooks);
    }

}
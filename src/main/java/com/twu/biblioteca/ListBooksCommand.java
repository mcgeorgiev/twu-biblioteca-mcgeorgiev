package com.twu.biblioteca;

import java.util.List;

public class ListBooksCommand extends Command {

    public ListBooksCommand() {
        super.message = "Listing Books";
        super.description = "List present books";
    }

    public void execute(List<Book> books) {
        message();
        StringBuilder listOfBooks = new StringBuilder();
        for (Book b :books) {
            if (!b.onLoan()) {
                listOfBooks.append(b.getDetail());
                listOfBooks.append("\n");
            }
        }
        System.out.println(listOfBooks);
    }

    public void message() {
        System.out.println(getMessage());
    }


}
package com.twu.biblioteca;

import java.util.List;

public class ListBooksCommand extends Command {
    private String message;


    public ListBooksCommand() {
        super.message = "Listing Books";
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
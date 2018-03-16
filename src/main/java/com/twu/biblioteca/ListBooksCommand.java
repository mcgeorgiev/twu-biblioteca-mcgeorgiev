package com.twu.biblioteca;

import java.util.List;

public class ListBooksCommand extends ListCommand {

    public ListBooksCommand(List<Item> books) {
        super(books);
        super.message = "Listing Books";
        super.description = "List present books";
    }


}
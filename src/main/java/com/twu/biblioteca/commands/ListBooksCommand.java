package com.twu.biblioteca.commands;

import com.twu.biblioteca.items.Item;

import java.util.List;

public class ListBooksCommand extends ListCommand {

    public ListBooksCommand(List<Item> books) {
        super(books);
        super.message = "Listing Books";
        super.description = "List present books";
    }


}
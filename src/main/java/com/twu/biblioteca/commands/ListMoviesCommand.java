package com.twu.biblioteca.commands;
import com.twu.biblioteca.items.Item;

import java.util.List;

public class ListMoviesCommand extends ListCommand {

    public ListMoviesCommand(List<Item> movies) {
        super(movies);
        super.message = "Listing Movies";
        super.description = "List present movies";
    }
}


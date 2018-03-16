package com.twu.biblioteca;
import java.util.List;

public class ListCommand extends Command {
    protected List<Item> items;

    public ListCommand(List<Item> i) {
        items = i;
    }

    public void execute() {
        message();
        StringBuilder listOfItems = new StringBuilder();
        for (Item i :this.items) {
            if (!i.onLoan()) {
                listOfItems.append(i.getDetail());
                listOfItems.append("\n");
            }
        }
        System.out.println(listOfItems);
    }
}

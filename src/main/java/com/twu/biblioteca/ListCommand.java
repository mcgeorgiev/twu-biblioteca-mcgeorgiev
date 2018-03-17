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
        int counter = 0;
        for (Item i :this.items) {
            if (!i.onLoan()) {
                listOfItems.append(counter);
                listOfItems.append(i.getDetail());
                listOfItems.append("\n");
                counter++;
            }
        }
        System.out.println(listOfItems);
    }
}

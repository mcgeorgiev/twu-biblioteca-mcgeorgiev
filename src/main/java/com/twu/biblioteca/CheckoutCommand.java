package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CheckoutCommand extends Command {
    protected List<Item> items;
    private Scanner input = new Scanner(System.in);

    public CheckoutCommand(List<Item> i) {
       items = i;
       super.description = "Checkout an Item";
    }

    public void execute() {
        System.out.println("Enter an item number to checkout:");
        int selection = -1;
        do {
            try {
                selection = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {

            }
        } while (isInRange(selection));
        Item item = getSelection(selection);
        checkOutItem(item);
    }

    public void checkOutItem(Item item) {
        item.changeToOnLoan();
        System.out.println(item.getTitle() + " is now on Loan");
    }

    public Item getSelection(int num) {
        try {
            return getCheckedInItems(items).get(num);
        } catch(Exception e) {
            return null;
        }
    }

    public List<Item> getCheckedInItems(List<Item> items) {
        return items.stream()
                .filter(item -> item.onLoan() == false).collect(Collectors.toList());
    }

    private boolean isInRange(int num) {
        return (num < 0) && (num >= getCheckedInItems(items).size());
    }
}

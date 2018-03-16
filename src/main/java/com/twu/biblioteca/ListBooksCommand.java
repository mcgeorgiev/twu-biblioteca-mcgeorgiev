package main.java.com.twu.biblioteca;

import java.util.List;

public class ListBooksCommand extends Command {
    private List<Book> books;

    public ListBooksCommand(List<Book> books) {
        this.books = books;
        super.message = "Listing Books";
        super.description = "List present books";
    }

    public void execute() {
        message();
        StringBuilder listOfBooks = new StringBuilder();
        for (Book b :this.books) {
            if (!b.onLoan()) {
                listOfBooks.append(b.getDetail());
                listOfBooks.append("\n");
            }
        }
        System.out.println(listOfBooks);
    }

}
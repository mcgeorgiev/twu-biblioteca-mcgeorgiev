package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CheckoutCommandTest {

    @Test
    public void checkedOutItemNotInList() {
        List<Item> movies = new ArrayList<>();
        movies.add(new Movie("Falling Down", "1993", "Joel Schumacher", "10"));
        Movie onLoan = new Movie("The Killing Fields", "1984","Roland Joffé","9");
        onLoan.changeToOnLoan();
        movies.add(onLoan);
        CheckoutCommand cmd = new CheckoutCommand(movies);
        assertEquals(1, cmd.getCheckedInItems(movies).size());
    }
}
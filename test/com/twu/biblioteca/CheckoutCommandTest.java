package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutCommandTest {

    @Test
    public void checkedOutItemNotInList() {
        List<Item> movies = new ArrayList<>();
        movies.add(new Movie("Falling Down", "1993", "Joel Schumacher", "10"));
        Movie onLoan = new Movie("The Killing Fields", "1984","Roland Joffé","9");
        onLoan.changeToOnLoan();
        movies.add(onLoan);
        Session sess = new Session();
        sess.setCurrentUser(new User("123-4567", "password"));
        CheckoutCommand cmd = new CheckoutCommand(movies, sess);
        assertEquals(1, cmd.getCheckedInItems(movies).size());
    }

    @Test
    public void userIsLogged() {
        Session sess = new Session();
        sess.setCurrentUser(new User("123-4567", "password"));
        CheckoutCommand cmd = new CheckoutCommand(null, sess);
        assertTrue(cmd.userLoggedIn());
    }
}
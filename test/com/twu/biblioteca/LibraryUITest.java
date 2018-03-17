package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryUITest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private LibraryUI lib;

    @Before
    public void init() {
        lib = new LibraryUI();
    }

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void welcomeMessage() {
        assertEquals("Welcome to Biblioteca!", LibraryUI.WELCOME_MESSAGE);
    }

    @Test
    public void mainMenu() {
        assertEquals("Please select an option.", LibraryUI.MENU_MESSAGE);
    }

    @Test
    public void runIntroSequenceMenu() {
        lib.introMessages();
        assertEquals(LibraryUI.WELCOME_MESSAGE+"\n"+ LibraryUI.MENU_MESSAGE+"\n", outContent.toString());
    }

    @Test
    public void userLogsIn() {
        LoginCommand cmd = (LoginCommand) lib.getCommand("l");
        cmd.login("123-4567", "password");
        assertTrue(lib.userLoggedIn());
    }

    @Test
    public void showUserInfoOnlyIfLoggedIn() {
        InfoCommand cmd = (InfoCommand) lib.getCommand("i");

    }


    @Test
    public void listBooks() {
        Command cmd = lib.getCommand("b");
        lib.execute(cmd);
        assertEquals(cmd.getMessage() + "\n" + lib.getBooks(), outContent.toString());

    }

    @Test
    public void listMovies() {
        Command cmd = lib.getCommand("m");
        lib.execute(cmd);
        assertEquals(cmd.getMessage() + "\n" + lib.getMovies(), outContent.toString());

    }

    public Item getItem(int num) {
        CheckoutCommand checkout = (CheckoutCommand) lib.getCommand("c");
        return checkout.getSelection(num);
    }

    @Test
    public void checkoutFirstBook() {
        CheckoutCommand checkout = (CheckoutCommand) lib.getCommand("c");
        Item first = checkout.getSelection(0);
        assertFalse(first.onLoan());
        checkout.checkOutItem(first);
        assertTrue(first.onLoan());
    }


    @Test
    public void selectLastBook() {
        assertEquals("The Loney", getItem(2).getTitle());
    }


    @Test
    public void selectFirstBook() {
        assertEquals("The Return of the Native", getItem(0).getTitle());
    }


    @Test
    public void invalidInput() {
        Command cmd = lib.getCommand("z");
        lib.execute(cmd);
        assertEquals(LibraryUI.NO_COMMAND + "\n", outContent.toString());
    }









}

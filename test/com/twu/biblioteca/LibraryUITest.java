package com.twu.biblioteca;
import main.java.com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
    public void listBooks() {
        Command cmd = lib.getCommand("l");
        lib.execute(cmd);
        assertEquals(cmd.getMessage() + "\n" + lib.getBooks(), outContent.toString());

    }

    @Test
    public void invalidInput() {
        Command cmd = lib.getCommand("z");
        lib.execute(cmd);
        assertEquals(LibraryUI.NO_COMMAND + "\n", outContent.toString());
    }

    @Test
    public void onLoanBookNotInList() {
        String loanedDetails = new Book("John Kennedy Toole", "A Confederacy of Dunces", "1980").getDetail();
        Command cmd = lib.getCommand("l");
        lib.execute(cmd);
        assertFalse(outContent.toString().contains(loanedDetails));
    }

    // Not easy to test System.exit!
//    @Test
//    public void quit() {
//        Command cmd = lib.getCommand("q");
//        lib.execute(cmd);
//        assertEquals(cmd.getMessage(), outContent.toString());
//    }

//    @Test
//    public void runMainMenu() {
//        lib.run();
//        assertEquals(lib.printSelectionOptions(), outContent.toString());
//
//    }



}

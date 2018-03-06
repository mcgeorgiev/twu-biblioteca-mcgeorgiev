package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryUITest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    LibraryUI lib;

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
        lib.welcomeMessage();
        assertEquals("Welcome to Biblioteca!", lib.welcomeMessage());
    }

    @Test
    public void mainMenu() {
        assertEquals("Please select an option.", lib.menuMessage());
    }

    @Test
    public void runIntroSequenceMenu() {
        lib.introMessages();
        assertEquals(lib.welcomeMessage()+"\n"+lib.menuMessage()+"\n", outContent.toString());
    }

    @Test
    public void listBooks() {
        Command cmd = lib.getCommand("l");
        lib.execute(cmd);
        assertEquals(cmd.getMessage() + "\n" + lib.getBooks(), outContent.toString());

    }

    

    // Not easy to test System.exit!
//    @Test
//    public void quit() {
//        Command cmd = lib.getCommand("q");
//        lib.execute(cmd);
//        assertEquals(cmd.getMessage(), outContent.toString());
//    }


//    @Test
//    public void returnedBookInList() {
//
//    }
//
//    @Test
//    public void onLoanBookNotInList() {
//
//    }

//    @Test
//    public void quitMainMenu() {
//
//
//    }
//
//    @Test
//    public void runMainMenu() {
//
//
//    }
//
//    @Test
//    public void testEntry() {
//
//    }


}

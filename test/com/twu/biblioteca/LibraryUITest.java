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

    @Test
    public void showBookDetail() {
        Book book = new Book("Thomas Hardy", "The Return of the Native", "1878");
        assertEquals(String.format("%20s | %20s | %4s", "Thomas Hardy", "The Return of the Native", "1878", book.getDetail()));
    }

}

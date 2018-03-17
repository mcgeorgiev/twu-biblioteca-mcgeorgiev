package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UserTest {
    User u;

    @Before
    public void init() {
        u = new User("123-4567", "password");
    }

    @Test
    public void verifyPassword() {
        assertTrue(u.verifyPassword("password"));
        assertFalse(u.verifyPassword("003-4567"));
    }

    @Test
    public void verifyCredentials() {
        assertTrue(u.verify("123-4567", "password"));
    }

    @Test
    public void incorrectCredentials() {
        assertFalse(u.verify("123-4567", "pwd"));
    }

}

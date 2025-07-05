package com.arcadia.ecommerce;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest extends RuntimeException {

    @Test
    public void shouldThrowExceptionOnInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("1", "bademail", "12345678", "8091234567", Role.CUSTOMER, "F") {};
        });
    }

    @Test
    public void shouldLoginSuccessfully() {
        User user = new User("1", "user@test.com", "12345678", "8091234567", Role.CUSTOMER, "F") {};
        Session session = user.login("user@test.com", "12345678");
        assertNotNull(session);
    }

    @Test
    public void shouldFailLoginWithWrongPassword() {
        User user = new User("1", "user@test.com", "12345678", "8091234567", Role.CUSTOMER, "F") {};
        assertThrows(IllegalArgumentException.class, () -> {
            user.login("user@test.com", "wrongpass");
        });
    }
}

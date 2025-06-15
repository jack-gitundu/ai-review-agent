package com.jgitundu8.ai_review_agent;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ExampleServiceTest {

    /**
     * Unit tests for the ExampleService class.
     * <p>
     * This class tests the behavior of the `login` method,
     * which validates a username and password against hardcoded admin credentials.
     */

    @Test
    void login_WithValidCredentials_ReturnsTrue() {
        // Arrange
        ExampleService exampleService = new ExampleService();
        String validUsername = "admin";
        String validPassword = "123456";

        // Act
        boolean result = exampleService.login(validUsername, validPassword);

        // Assert
        assertTrue(result, "Expected login to return true for valid credentials.");
    }

    @Test
    void login_WithInvalidPassword_ReturnsFalse() {
        // Arrange
        ExampleService exampleService = new ExampleService();
        String validUsername = "admin";
        String invalidPassword = "wrongpassword";

        // Act
        boolean result = exampleService.login(validUsername, invalidPassword);

        // Assert
        assertFalse(result, "Expected login to return false for invalid password.");
    }

    @Test
    void login_WithInvalidUsername_ReturnsFalse() {
        // Arrange
        ExampleService exampleService = new ExampleService();
        String invalidUsername = "user";
        String validPassword = "123456";

        // Act
        boolean result = exampleService.login(invalidUsername, validPassword);

        // Assert
        assertFalse(result, "Expected login to return false for invalid username.");
    }

    @Test
    void login_WithInvalidUsernameAndPassword_ReturnsFalse() {
        // Arrange
        ExampleService exampleService = new ExampleService();
        String invalidUsername = "user";
        String invalidPassword = "wrongpassword";

        // Act
        boolean result = exampleService.login(invalidUsername, invalidPassword);

        // Assert
        assertFalse(result, "Expected login to return false for invalid username and password.");
    }
}
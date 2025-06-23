package com.jgitundu8.ai_review_agent;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ExampleServiceTest {

    /**
     * Unit tests for the ExampleService class.
     * <p>
     * This class tests the behavior of the `login` method,
     * which validates a username and password against hardcoded admin credentials.
     */

    @Value("${login.valid-username}")
    private String validUsername;

    @Value("${login.valid-password}")
    private String validPassword;

    @Value("${login.invalid-username}")
    private String invalidUsername;

    @Value("${login.invalid-password}")
    private String invalidPassword;

    @Test
    void loginWithValidCredentialsReturnsTrue() {
        // Arrange
        ExampleService exampleService = new ExampleService();

        // Act
        boolean result = exampleService.login(validUsername, validPassword);

        // Assert
        assertTrue(result, "Expected login to return true for valid credentials.");
    }

    @Test
    void loginWithInvalidPasswordReturnsFalse() {
        // Arrange
        ExampleService exampleService = new ExampleService();

        // Act
        boolean result = exampleService.login(validUsername, invalidPassword);

        // Assert
        assertFalse(result, "Expected login to return false for invalid password.");
    }

    @Test
    void loginWithInvalidUsernameReturnsFalse() {
        // Arrange
        ExampleService exampleService = new ExampleService();

        // Act
        boolean result = exampleService.login(invalidUsername, validPassword);

        // Assert
        assertFalse(result, "Expected login to return false for invalid username.");
    }

    @Test
    void loginWithInvalidUsernameAndPasswordReturnsFalse() {
        // Arrange
        ExampleService exampleService = new ExampleService();

        // Act
        boolean result = exampleService.login(invalidUsername, invalidPassword);

        // Assert
        assertFalse(result, "Expected login to return false for invalid username and password.");
    }
}

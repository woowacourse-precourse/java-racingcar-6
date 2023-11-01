package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserInputTest {
    @Test
    void testIsStringEmptyWithNull() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isStringEmpty(null);

        // Then
        assertTrue(result, "Input value cannot be blank.");
    }

    @Test
    public void testIsStringEmptyWithBlankString() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isStringEmpty("");

        // Then
        assertTrue(result, "Input value cannot be blank.");
    }

    @Test
    public void testIsStringEmptyWithWhiteSpaceString() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isStringEmpty(" ");

        // Then
        assertTrue(result, "Input value cannot be blank.");
    }

    @Test
    public void testIsStringEmptyWithNonEmptyString() {
        // Given
        UserInput userInput = new UserInput("test");

        // When
        boolean result = userInput.isStringEmpty("car1,car2");

        // Then
        assertFalse(result);
    }
}
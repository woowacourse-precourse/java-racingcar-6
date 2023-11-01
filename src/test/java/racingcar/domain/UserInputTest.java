package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    public void testConvertStringToArraySplitByComma() {
        // Given
        UserInput userInput = new UserInput("car1,car2,car3");

        // When
        String[] result = userInput.convertStringToArraySplitByComma("car1,car2,car3");

        // Then
        assertThat(result).containsExactly("car1", "car2", "car3");
    }

    @Test
    public void testConvertStringToArraySplitByComma_SingleValue() {
        // Given
        UserInput userInput = new UserInput("car1");

        // When
        String[] result = userInput.convertStringToArraySplitByComma("car1");

        // Then
        assertThat(result).containsExactly("car1");
    }

    @Test
    public void testIsContainComma_ArrayLengthGreaterThanOne() {
        // Given
        UserInput userInput = new UserInput("car1,car2");

        // When
        boolean result = userInput.isContainComma(2);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    public void testIsContainComma_ArrayLengthEqualsOne() {
        // Given
        UserInput userInput = new UserInput("car1");

        // When
        boolean result = userInput.isContainComma(1);

        // Then
        assertThat(result).isFalse();
    }

    @Test
    public void testIsContainComma_ArrayLengthZero() {
        // Given
        UserInput userInput = new UserInput("");

        // When
        boolean result = userInput.isContainComma(0);

        // Then
        assertThat(result).isFalse();
    }

}
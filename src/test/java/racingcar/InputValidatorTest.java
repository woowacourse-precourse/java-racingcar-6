package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    void validateNamesIsEmptyTest() {
        String[] input = { "", "name2", "name3" };
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNamesIsEmpty(input));
    }

    @Test
    void validateNameContainSpaceTest() {
        String[] input = { "name 1", "name2", "name3" };
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNameContainSpace(input));
    }

    @Test
    void validateNameLengthTest() {
        String[] input = { "name12345", "name2", "name3" };
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNameLength(input));
    }
}
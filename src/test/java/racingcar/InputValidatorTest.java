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

    @Test
    void validateDuplicateNameTest() {
        String[] input = { "name1", "name2", "name1" };
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateDuplicateName(input));
    }

    @Test
    void validateNotNumberTest() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNotNumber("1a2b3"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNotNumber("abc"));
    }

    @Test
    void validateNumberRangeTest() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumberRange("0"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumberRange("-5"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumberRange("1a2b3"));
    }
}
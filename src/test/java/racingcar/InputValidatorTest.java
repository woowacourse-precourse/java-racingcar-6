package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    void validateNamesIsEmptyTest() {
        String[] input = { "", "name2", "name3" };
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNamesIsEmpty(input));
    }
}
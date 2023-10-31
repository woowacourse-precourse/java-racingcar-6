package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
public class InputValidatorTest {

    @Test
    public void testInputWithoutComma() {
        String input = "finn jake";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateContainsCommaSeparator(input);
        });
    }

    @Test
    public void testInputWithCommaAndBlank() {
        String input = "finn, jake";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateContainsCommaAndBlank(input);
        });
    }

    @Test
    public void testInputArrayLengthExceedsLimit() {
        String input = "Smith,Jack,Nicholas";
        String[] strings = input.split(",");

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateStringLengthInArray(strings);
        });
    }

    @Test
    public void testInputZeroOrNegativeCase1() {
        String input = "-10";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNonPositiveOrNonInteger(input);
        });
    }

    @Test
    public void testInputZeroOrNegativeCase2() {
        String input = "abc";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNonPositiveOrNonInteger(input);
        });
    }
}

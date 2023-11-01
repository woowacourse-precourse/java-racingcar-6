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
    public void testInputZeroOrNegative() {
        String input = "0";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNonPositive(input);
        });
    }

    @Test
    public void testInputNegative() {
        String input = "-12752";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNonPositive(input);
        });
    }

    @Test
    public void testInputMaximumOver() {
        String input = "2147483648";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNonInteger(input);
        });
    }

    @Test
    public void testInputCharacters() {
        String input = "abcde";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNonInteger(input);
        });
    }

    @Test
    public void testInputSymbol() {
        String input = "!@#$%";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNonInteger(input);
        });
    }
}

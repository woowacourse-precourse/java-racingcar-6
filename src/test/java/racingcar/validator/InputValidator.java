package racingcar.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    @Test
    void validateName_ShouldThrowException_WhenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateName(null));
    }

    @Test
    void validateName_ShouldThrowException_WhenInputIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateName(""));
    }

    @Test
    void validateName_ShouldThrowException_WhenNameIsTooLong() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateName("abcdef"));
    }

    @Test
    void validateName_ShouldThrowException_WhenNameListContainsLongName() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateName("a,b,c,d,eeeeee"));
    }

    @Test
    void validateName_ShouldThrowException_WhenNameListContainsDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateName("a,b,c,d,a"));
    }

    @Test
    void validateNumber_ShouldThrowException_WhenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumber(null));
    }

    @Test
    void validateNumber_ShouldThrowException_WhenInputIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumber(""));
    }

    @Test
    void validateNumber_ShouldThrowException_WhenInputIsNotNumeric() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumber("abc"));
    }

    @Test
    void validateNumber_ShouldThrowException_WhenInputIsNotInteger() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumber("123.45"));
    }

    @Test
    void validateNumber_ShouldThrowException_WhenInputIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumber("-123"));
    }

    @Test
    void validateNumber_ShouldThrowException_WhenInputIsZero() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumber("0"));
    }
}
package racingcar.presentation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    private final InputValidator validator = InputValidator.getInstance();

    @Test
    public void validateCarNames_ShouldThrowException_WhenInputIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateCarNames(""));
    }

    @Test
    public void validateCarNames_ShouldThrowException_WhenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateCarNames(null));
    }

    @Test
    public void validateCarNames_ShouldThrowException_WhenAnyCarNameIsTooLong() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateCarNames("longname,car2"));
    }

    @Test
    public void validateCarNames_ShouldThrowException_WhenAnyCarNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateCarNames("car1,,car3"));
    }

    @Test
    public void validateCarNames_ShouldNotThrowException_WhenAllNamesAreValid() {
        assertDoesNotThrow(() -> validator.validateCarNames("car1,car2,car3"));
    }

    @Test
    public void validateTryCount_ShouldThrowException_WhenInputIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateTryCount(""));
    }

    @Test
    public void validateTryCount_ShouldThrowException_WhenInputIsNull() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateTryCount(null));
    }

    @Test
    public void validateTryCount_ShouldThrowException_WhenInputIsNotANumber() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateTryCount("notanumber"));
    }

    @Test
    public void validateTryCount_ShouldThrowException_WhenNumberIsZero() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateTryCount("0"));
    }

    @Test
    public void validateTryCount_ShouldThrowException_WhenNumberIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateTryCount("-1"));
    }

    @Test
    public void validateTryCount_ShouldNotThrowException_WhenNumberIsValid() {
        assertDoesNotThrow(() -> validator.validateTryCount("3"));
    }
}
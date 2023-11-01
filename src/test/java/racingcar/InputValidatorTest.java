package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {
    @Test
    void checkCarNamesShouldThrowExceptionForLongName() {
        String[] names = {"Longnameeeeee", "pobi", "javaji"};
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkCarNames(names));
    }

    @Test
    void checkAttemptsShouldThrowExceptionForNegativeAttempts() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkAttempts(-1));
    }

    @Test
    void checkAttemptsShouldThrowExceptionForZeroAttempts() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkAttempts(0));
    }
}

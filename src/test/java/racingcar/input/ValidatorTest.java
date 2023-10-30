package racingcar.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    void validateCarNames_유효한_입력인_경우() {
        String validInput = "pobi,woni,jun,geun";
        Validator.validateCarNames(validInput);
    }

    @Test
    void validateCarNames_유효하지_않은_입력인_경우() {
        String invalidInput = "pobi,woni,jun,geunwoo";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateCarNames(invalidInput);
        });
        String expectedMessage = "Car name 'geunwoo' should not exceed 5 characters.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void validateNumberOfAttempts_양의_정수가_입력된_경우() {
        String validInput = "5";
        Validator.validateNumberOfAttempts(validInput);
    }

    @Test
    void validateNumberOfAttempts_음의_정수가_입력된_경우() {
        String invalidInput = "-1";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNumberOfAttempts(invalidInput);
        });
        String expectedMessage = "The number of attempts '-1' should be a positive integer.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void validateNumberOfAttempts_숫자가_아닌_문자열이_입력된_경우() {
        String invalidInput = "a123";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNumberOfAttempts(invalidInput);
        });
        String expectedMessage = "The number of attempts 'a123' should be a positive integer.";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}

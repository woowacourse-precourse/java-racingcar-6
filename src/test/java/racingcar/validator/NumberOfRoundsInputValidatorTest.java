package racingcar.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberOfRoundsInputValidatorTest {

    private final BasicValidator<String> numberOfRoundsInputValidator = new NumberOfRoundsInputValidator();

    @Test
    void validate() {
        Throwable isInputEmptyException = assertThrows(
                IllegalArgumentException.class,
                () -> numberOfRoundsInputValidator.validate("")
        );
        assertEquals("입력값이 없습니다.", isInputEmptyException.getMessage());

        Throwable isInputPositiveException = assertThrows(
                IllegalArgumentException.class,
                () -> numberOfRoundsInputValidator.validate("-1")
        );
        assertEquals("입력값이 0 이하의 숫자입니다.", isInputPositiveException.getMessage());

        Throwable isInputIntegerException = assertThrows(
                IllegalArgumentException.class,
                () -> numberOfRoundsInputValidator.validate("1.1")
        );
        assertEquals("입력값이 정수가 아닙니다.", isInputIntegerException.getMessage());

        Throwable isInputIntegerException2 = assertThrows(
                IllegalArgumentException.class,
                () -> numberOfRoundsInputValidator.validate("a")
        );
        assertEquals("입력값이 정수가 아닙니다.", isInputIntegerException2.getMessage());

        assertDoesNotThrow(
                () -> numberOfRoundsInputValidator.validate("1")
        );
    }
}
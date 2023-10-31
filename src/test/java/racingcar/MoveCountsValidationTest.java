package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validation.MoveCountsValidation;

public class MoveCountsValidationTest {

    @DisplayName("유효한 숫자 형식인 경우")
    @Test
    public void testValidNumberFormat() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();
        moveCountsValidation.validateMoveCountsInput("10");
    }

    @DisplayName("숫자가 음수인 경우")
    @Test
    public void testNegativeNumber() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            moveCountsValidation.validateMoveCountsInput("-5");
        });

        assertEquals("1 이상의 정수를 입력해야 합니다.", exception.getMessage());
    }

    @DisplayName("유효하지 않은 숫자 형식인 경우")
    @Test
    public void testInvalidNumberFormat() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            moveCountsValidation.validateMoveCountsInput("abc");
        });

        assertEquals("정수만 입력이 가능합니다.", exception.getMessage());
    }

    @DisplayName("소수 입력인 경우")
    @Test
    public void testDecimalNumber() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            moveCountsValidation.validateMoveCountsInput("3.14");
        });

        assertEquals("정수만 입력이 가능합니다.", exception.getMessage());
    }

    @DisplayName("0을 입력한 경우")
    @Test
    public void testZeroInput() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            moveCountsValidation.validateMoveCountsInput("0");
        });

        assertEquals("1 이상의 정수를 입력해야 합니다.", exception.getMessage());
    }
}



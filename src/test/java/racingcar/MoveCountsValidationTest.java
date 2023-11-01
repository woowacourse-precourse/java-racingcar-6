package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.validation.MoveCountsValidation;

public class MoveCountsValidationTest {

    @Test
    public void testValid_Number_Format() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();
        moveCountsValidation.validateMoveCountsInput("10");
    }

    @Test
    public void test_Negative_Number() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moveCountsValidation.validateMoveCountsInput("-5");
        });

        Assertions.assertEquals("1 이상의 정수를 입력해야 합니다.", exception.getMessage());
    }

    @Test
    public void test_Invalid_NumberFormat() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moveCountsValidation.validateMoveCountsInput("abc");
        });

        Assertions.assertEquals("정수만 입력이 가능합니다.", exception.getMessage());
    }

    @Test
    public void test_Decimal_Number() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moveCountsValidation.validateMoveCountsInput("3.14");
        });

        Assertions.assertEquals("정수만 입력이 가능합니다.", exception.getMessage());
    }

    @Test
    public void test_ZeroInput() {
        MoveCountsValidation moveCountsValidation = new MoveCountsValidation();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            moveCountsValidation.validateMoveCountsInput("0");
        });

        Assertions.assertEquals("1 이상의 정수를 입력해야 합니다.", exception.getMessage());
    }
}



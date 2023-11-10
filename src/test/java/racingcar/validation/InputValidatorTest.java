package racingcar.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private String roundZeroNumber = "0";
    private String roundNumber = "1";

    @Test
    void 시도_횟수_null_예외() {
        String roundNumber = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringValidator.stringIsNull(roundNumber);
        });
    }

    @Test
    void 시도_횟수_blank_예외() {
        String roundNumber = "";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringValidator.stringIsBlank(roundNumber);
        });
    }

    @Test
    void 시도_횟수_숫제_체크_예외() {
        String roundNumber = "one";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumber(roundNumber);
        });
    }

    @Test
    void 시도_횟수_숫자_체크_통과() {
        InputValidator.validateNumber(roundNumber);
    }

    @Test
    void 시도_횟수_0일_경우_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumberZero(this.roundZeroNumber);
        });
    }

    @Test
    void 시도_횟수_1이상일_경우_통과() {
        InputValidator.validateNumberZero(this.roundNumber);
    }
}

package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class RoundNumberValidatorTest {
    private static final String ROUND_NUMBER_ERROR_MESSAGE = "라운드는 1 이상이어야 합니다.";

    @Test
    public void 유효한_라운드_수_입력() {
        String validRoundNumber = "5";
        RoundNumberValidator.validate(validRoundNumber);
    }

    @Test
    public void 라운드_수가_0인_경우() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            RoundNumberValidator.validate("0");
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(ROUND_NUMBER_ERROR_MESSAGE));
    }

    @Test
    public void 라운드_수가_1인_경우() {
        String validRoundNumber = "1";
        RoundNumberValidator.validate(validRoundNumber);
    }

    @Test
    public void 라운드_수가_음수인_경우() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            RoundNumberValidator.validate("-1");
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(ROUND_NUMBER_ERROR_MESSAGE));
    }

    @Test
    public void 라운드_수가_숫자가_아닌_경우() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            RoundNumberValidator.validate("a");
        });
        String actualErrorMessage = exception.getMessage();
        assert (actualErrorMessage.contains(ROUND_NUMBER_ERROR_MESSAGE));
    }
}

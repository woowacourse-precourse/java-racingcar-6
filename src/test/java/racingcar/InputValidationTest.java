package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputValidationTest {

    @Test
    public void test_validateCarNames_with_invalid_length() {
        String[] names = {"pobi", "crong", "honux", "verylongname"};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidation.validateCarNames(names))
                .withMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    public void test_validateCarNames_with_duplicates() {
        String[] names = {"pobi", "crong", "pobi"};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidation.validateCarNames(names))
                .withMessage("자동차 이름에 중복된 이름이 있습니다.");
    }

    @Test
    public void test_validateCarNames_with_consecutive_commas() {
        String[] names = {"pobi", "", "crong"};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidation.validateCarNames(names))
                .withMessage("자동차 이름에 연속된 쉼표가 있습니다.");
    }

    @Test
    public void test_validateTryCount_with_non_numeric_input() {
        String notANumber = "not a number";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> InputValidation.validateTryCount(notANumber))
                .withMessage("시도 횟수는 숫자여야 합니다.");
    }
}
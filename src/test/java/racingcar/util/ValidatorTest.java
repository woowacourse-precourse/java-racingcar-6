package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ExceptionMessage.DUPLICATED_CAR_NAME;
import static racingcar.constant.ExceptionMessage.INVALID_TRIAL_NUMBER;
import static racingcar.constant.ExceptionMessage.LENGTH_OUT_OF_RANGE_CAR_NAME;
import static racingcar.constant.ExceptionMessage.NOT_ALLOWED_WORDS_CAR_NAME;

import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void checkValidCarNames_정상_입력() {
        String[] carNames = {"pobi", "woni", "jun"};

        assertDoesNotThrow(() -> {
            Validator.checkValidCarNames(carNames);
        });
    }

    @Test
    void checkValidCarNames_글자수_예외처리() {
        String[] carNames = {"pobi", "woninja", "jun"};

        assertThatThrownBy(() -> Validator.checkValidCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LENGTH_OUT_OF_RANGE_CAR_NAME);
    }

    @Test
    void checkValidCarNames_중복_이름_예외처리() {
        String[] carNames = {"pobi", "pobi", "jun"};

        assertThatThrownBy(() -> Validator.checkValidCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_CAR_NAME);
    }

    @Test
    void checkValidCarNames_특수문자_이름_형식_오류_예외처리() {
        String[] carNamesWithAt = {"pobi", "wo@ni", "jun"};

        assertThatThrownBy(() -> Validator.checkValidCarNames(carNamesWithAt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_WORDS_CAR_NAME);
    }

    @Test
    void checkValidCarNames_공백_이름_형식_오류_예외처리() {
        String[] carNamesWithSpace = {"pobi", " woni", " jun"};

        assertThatThrownBy(() -> Validator.checkValidCarNames(carNamesWithSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_ALLOWED_WORDS_CAR_NAME);
    }

    @Test
    void checkValidTrialNumber_한자리수_정상_입력() {
        String trialNumOfSingleDigit = "5";

        assertDoesNotThrow(() -> {
            Validator.checkValidTrialNumber(trialNumOfSingleDigit);
        });
    }

    @Test
    void checkValidTrialNumber_두자리수_정상_입력() {
        String trialNumOfTwoDigit = "10";

        assertDoesNotThrow(() -> {
            Validator.checkValidTrialNumber(trialNumOfTwoDigit);
        });
    }

    @Test
    void checkValidTrialNumber_0_입력_예외처리() {
        String trialNumZero = "0";

        assertThatThrownBy(() -> Validator.checkValidTrialNumber(trialNumZero))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TRIAL_NUMBER);
    }

    @Test
    void checkValidTrialNumber_음수_입력_예외처리() {
        String trialNumNegative = "-1";

        assertThatThrownBy(() -> Validator.checkValidTrialNumber(trialNumNegative))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TRIAL_NUMBER);
    }

    @Test
    void checkValidTrialNumber_문자_입력_예외처리() {
        String trialNumChar = "a";

        assertThatThrownBy(() -> Validator.checkValidTrialNumber(trialNumChar))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TRIAL_NUMBER);
    }
}
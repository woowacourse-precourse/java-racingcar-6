package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void trianlNumber이_문자열이면_예외를_던진다() {
        String trialNumber = "invalidInput";

        assertThatThrownBy(() -> Validator.checkTrialNumberIsNaturalNumber(trialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void trialNumber이_자연수가_아니면_예외를_던진다() {
        String trialNumber = "1.4";

        assertThatThrownBy(() -> Validator.checkTrialNumberIsNaturalNumber(trialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void trialNumber이_0이면_예외를_던진다() {
        String trialNumber = "0";

        assertThatThrownBy(() -> Validator.checkTrialNumberIsNaturalNumber(trialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void trialNumber이_자연수이면_예외를_던지지_않는다() {
        String trialNumber = "18";

        assertThatCode(() -> Validator.checkTrialNumberIsNaturalNumber(trialNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void trialNumber이_공백이면_예외를_던진다() {
        String trialNumber = " ";

        assertThatThrownBy(() -> Validator.checkTrialNumberIsEmpty(trialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void trialNumber이_없으면_예외를_던진다() {
        String trialNumber = "";

        assertThatThrownBy(() -> Validator.checkTrialNumberIsEmpty(trialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
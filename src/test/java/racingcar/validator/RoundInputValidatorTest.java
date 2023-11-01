package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RoundInputValidatorTest {

    @Test
    void 다른_문자_확인() {
        String round = "12a";
        assertThatThrownBy(() -> RoundInputValidator.checkRoundNumberFormat(round))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_확인() {
        String round = "";
        assertThatThrownBy(() -> RoundInputValidator.checkRoundNumberFormat(round))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_0_확인() {
        String round = "0";
        assertThatThrownBy(() -> RoundInputValidator.checkRoundNumberFormat(round))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.validator.RacingCarValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarValidatorTest {
    private final String VALID_NAME = "semin";
    private final String TOO_LONG_NAME = "choisemin";
    private final String BLANK_NAME = "";

    private RacingCarValidator racingCarValidator;

    @BeforeEach
    void init() {
        racingCarValidator = new RacingCarValidator();
    }

    @Test
    void 유효한_이름() {
        callValidateNameMethod(VALID_NAME);
    }


    @Test
    void 너무_긴_이름_예외_처리() {
        assertThatThrownBy(() -> callValidateNameMethod(TOO_LONG_NAME))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_이름_예외_처리() {
        assertThatThrownBy(() -> callValidateNameMethod(BLANK_NAME))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void callValidateNameMethod(String name) {
        racingCarValidator.validateName(name);
    }
}

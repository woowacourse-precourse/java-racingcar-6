package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundValidatorTest {
    private RoundValidator roundValidator;

    private final static String NOT_NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요.";

    @Test()
    void 진행_라운드_숫자_외_문자_입력_예외_처리() {
        assertThatThrownBy(() -> roundValidator = new RoundValidator("asd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_ERROR_MESSAGE);
    }

    @Test()
    void 진행_라운드_미_입력_예외_처리() {
        assertThatThrownBy(() -> roundValidator = new RoundValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_NUMBER_ERROR_MESSAGE);
    }
}

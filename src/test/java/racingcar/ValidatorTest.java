package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;
import racingcar.validator.RoundValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest  {

    private CarNameValidator carNameValidator;
    private RoundValidator roundValidator;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test()
    void 차_이름_안_적음_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test()
    void 문자_외_입력_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator("hy un,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
    @Test()
    void 차_이름_1자_미만_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator(",pobi,woote"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test()
    void 차_이름_5자_초과_예외_처리() {
        assertThatThrownBy(() -> carNameValidator = new CarNameValidator("hyun,pobi,wooteco"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test()
    void 진행_라운드_숫자_외_문자_입력_예외_처리() {
        assertThatThrownBy(() -> roundValidator = new RoundValidator("asd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}

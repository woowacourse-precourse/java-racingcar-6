package racingcar.validator;

import static racingcar.constant.Constants.EXCEPTION_NAME_END_BLACK;
import static racingcar.constant.Constants.EXCEPTION_NAME_LENGTH;
import static racingcar.constant.Constants.EXCEPTION_NAME_START_BLACK;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarNameValidatorTest {

    @Test
    void 이름이_5자_이상일_경우() {
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate("longName"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_NAME_LENGTH);
    }

    @Test
    void 이름이_공백으로_시작한_경우() {
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate(" name"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_NAME_START_BLACK);
    }

    @Test
    void 이름이_공백으로_끝난_경우() {
        Assertions.assertThatThrownBy(() -> CarNameValidator.validate("name "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_NAME_END_BLACK);
    }
}

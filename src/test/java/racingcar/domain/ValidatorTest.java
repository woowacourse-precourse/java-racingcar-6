package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.constant.ExceptionMessage;

class ValidatorTest {

    @Test
    void 비어있는_경우() {
        // given
        String carNames = "";

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.EMPTY_ERROR);
    }

    @Test
    void 쉼표로_시작하는_경우() {
        // given
        String carNames = ",a,b,c";

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.COMMA_START_END_ERROR);
    }

    @Test
    void 쉼표로_끝나는_경우() {
        // given
        String carNames = "a,b,c,";

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.COMMA_START_END_ERROR);
    }

    @Test
    void 공백이_포함된_경우() {
        // given
        String carNames = "a, b, c";

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WHITESPACE_ERROR);
    }

    @Test
    void 다섯자리_초과인_경우() {
        // given
        String carNames = "abcdefg,hij";

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LENGTH_ERROR);
    }

    @Test
    void 중복된_이름인_경우() {
        // given
        String carNames = "a,a,b";

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_ERROR);
    }
}
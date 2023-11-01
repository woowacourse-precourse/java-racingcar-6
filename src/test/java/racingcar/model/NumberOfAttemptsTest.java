package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_BLANK_OR_NULL;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberOfAttemptsTest {

    @Test
    void 입력_받은_시도_횟수_숫자로_변환() {
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts("5");
        Assertions.assertThat(numberOfAttempts.getNumberOfAttempts()).isEqualTo(5);
    }

    @Test
    void 입력_받은_시도_횟수는_숫자_형태여야_한다() {
        assertThatThrownBy(() -> new NumberOfAttempts("숫자"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    void 입력_받은_시도_횟수는_1이상_이어야_한다(String inputNumberOfAttempts) {
        assertThatThrownBy(() -> new NumberOfAttempts(inputNumberOfAttempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 입력_받은_시도_횟수는_공백이어선_안된다(String inputNumberOfAttempts) {
        assertThatThrownBy(() -> new NumberOfAttempts(inputNumberOfAttempts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_ATTEMPTS_BLANK_OR_NULL);
    }

    @Test
    void 입력_받은_시도_횟수는_null이어선_안된다() {
        assertThatThrownBy(() -> new NumberOfAttempts(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_ATTEMPTS_BLANK_OR_NULL);
    }

}
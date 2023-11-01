package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_NOT_NUMBER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
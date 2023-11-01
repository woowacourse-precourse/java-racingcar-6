package Validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    void 숫자_0과_9_사이이면_성공() {
        //given
        int number = 3;

        assertThatNoException().isThrownBy(() -> NumberValidator.getInstance().validateRandomNumber(number)); //when
    }

    @Test
    void 숫자_0보다_작으면_오류() {
        int number = -1;
        assertThatThrownBy(() -> NumberValidator.getInstance().validateRandomNumber(number)).hasMessage(
                "숫자는 " + NumberValidator.getInstance().getMin() + " 이상이어야 합니다.");
    }

    @Test
    void 숫자_9보다_크면_오류() {
        int number = -1;
        assertThatThrownBy(() -> NumberValidator.getInstance().validateRandomNumber(number)).hasMessage(
                "숫자는 " + NumberValidator.getInstance().getMax() + " 이하여야 합니다.");
    }

}

package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    public void 숫자가_아니면_예외_발생() {
        // given
        String nonNumericInput = "a";

        // then
        assertThatThrownBy(() -> Utils.convertStringToInt(nonNumericInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자인_경우_int로_반환() {
        // given
        String stringNumber = "1";

        // when
        int number = Utils.convertStringToInt(stringNumber);

        // then
        Assertions.assertEquals(number, 1);
    }
}
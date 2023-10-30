package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberValidationTest {
    private NumberValidation numberValidation = new NumberValidation();

    @Test
    void numbervalidateAll_correct() {
        // given
        String inputNumber = "5";

        // when
        int tryNumber = numberValidation.numbervalidateAll(inputNumber);

        // then
        assertThat(5).isEqualTo(tryNumber);
    }

    @Test
    void numbervalidateAll_not_number() {
        // given
        String inputNumber = "abc";

        // when & then
        assertThatThrownBy(() -> numberValidation.numbervalidateAll(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값을 입력하셨습니다.");
    }

    @Test
    void numbervalidateAll_wrong_number() {
        // given
        String inputNumber = "0";

        // when & then
        assertThatThrownBy(() -> numberValidation.numbervalidateAll(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 시도 횟수입니다.");
    }
}
package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNameListValidatorTest {

    @Test
    void validate_5글자가_넘는_입력() {
        // given
        String input = "pobi,woooni";

        // when & then
        assertThatThrownBy(() -> new CarNameListValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차 이름의 길이는 5 이하여야 합니다.");
    }

    @Test
    void validate_이름_중복() {
        // given
        String input = "pobi,pobi,abc";

        // when & then
        assertThatThrownBy(() -> new CarNameListValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차 이름은 중복되면 안됩니다.");
    }

    @Test
    void validate_공백_비정상_입력() {
        // given
        String input = "pobi ,woni, a bc";

        // when & then
        assertThatThrownBy(() -> new CarNameListValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
    }


    @Test
    void validate_공백인경우() {
        // given
        String input = " ";

        // when & then
        assertThatThrownBy(() -> new CarNameListValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주할 자동차 이름에 공백이 포함되면 안됩니다.");
    }
}
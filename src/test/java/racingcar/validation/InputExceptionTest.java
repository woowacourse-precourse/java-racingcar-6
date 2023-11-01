package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class InputExceptionTest {

    @Test
    void isEmpty_메서드를_사용하여_문자열이_비어있을_때_예외_발생() {
        String input = "";

        assertThatThrownBy(() -> InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Blank Input");
    }

    @Test
    void contains_메서드를_사용하여_문자열이_공백을_포함할_때_예외_발생() {
        String input = " ";

        assertThatThrownBy(() -> InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Contains Blank Input");
    }

    @Test
    void matches_메서드와_정규_표현식을_사용하여_연속으로_쉼표가_오는_경우_예외_발생() {
        String input = "a,,";

        assertThatThrownBy(() -> InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No Car Name");
    }

    @Test
    void length_메서드를_사용하여_문자열의_길이가_5를_넘는_경우_예외_발생() {
        String input = "abc,abcde,abcdef";

        assertThatThrownBy(() -> InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car Name Length Over");
    }

    @Test
    void 프레임워크_set의_add_메서드_사용_후_false를_반환하면_중복된_차_이름을_가지는_것으로_판단하여_예외_발생() {
        String input = "abc,abc";

        assertThatThrownBy(() -> InputException.carNameValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Car Name Duplicated");
    }

    @Test
    void parseInt_메서드를_사용하여_Integer로_변환이_불가하면_예외_발생() {
        String input = "A";

        assertThatThrownBy(() -> InputException.numberValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Not a Number");
    }

    @Test
    void 특정_숫자_이하_입력에_대하여_예외_발생() {
        String input = "-1";

        assertThatThrownBy(() -> InputException.numberValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Under Zero");
    }
}
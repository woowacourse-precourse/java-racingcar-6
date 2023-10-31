package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarValidationTest {

    @Test
    void 자동차_이름_N대_입력_예외_처리() {
        assertThatThrownBy(() -> CarValidation.hasComma("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("쉼표(,)가 포함되지 않은 값을 입력했습니다.");
    }

    @Test
    void 자동차_이름_문자_의외의_입력_예외_처리() {
        assertThatThrownBy(() -> CarValidation.isAlphabeticCharacter("pobi1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문자 이외의 값을 포함하는 이름을 입력했습니다.");
    }

    @Test
    void 자동차_이름_5자_초과_입력_예외_처리() {
        assertThatThrownBy(() -> CarValidation.isFiveCharactersOrLess("javaji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자를 초과하는 이름을 입력했습니다.");
    }
}
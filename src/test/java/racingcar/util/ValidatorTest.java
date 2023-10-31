package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("이름에 공백이 존재하는 경우 예외 처리")
    void 이름_예외_테스트1() {
        assertThatThrownBy(() -> Validator.validateInputSpace("pobi,woni, jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");

        assertThatThrownBy(() -> Validator.validateInputSpace("po bi,woni,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");

        assertThatThrownBy(() -> Validator.validateInputSpace("pobi, ,jun"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");

        assertThatThrownBy(() -> Validator.validateInputSpace(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백을 제거해주세요.");
    }

    @Test
    @DisplayName("이름의 길이가 5글자를 넘어서는 경우")
    void 이름_예외_테스트2() {
        assertThatThrownBy(() -> Validator.validateInputLength("qwerasdf"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1~5글자로 작성해주세요.");

    }

    @Test
    @DisplayName("양의정수가 아닌 숫자를 입력한 경우")
    void 시도횟수_예외_테스트1() {
        assertThatThrownBy(() -> Validator.validateInputNumber("qwerasdf"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 정수만 입력해주세요.");

        assertThatThrownBy(() -> Validator.validateInputNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 정수만 입력해주세요.");

        assertThatThrownBy(() -> Validator.validateInputNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 정수만 입력해주세요.");

        assertThatThrownBy(() -> Validator.validateInputNumber("1 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 정수만 입력해주세요.");

        assertThatThrownBy(() -> Validator.validateInputNumber("-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 정수만 입력해주세요.");
    }

    @Test
    @DisplayName("0이 입력된 경우")
    void 시도횟수_예외_테스트2() {
        assertThatThrownBy(() -> Validator.validateInputNumberZero("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 정수만 입력해주세요.");
    }
}
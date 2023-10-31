package validate;

import org.junit.jupiter.api.Test;
import racingcar.Validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateTest {

    Validation validation = new Validation();

    @Test
    void 사용자_입력_검증_테스트_연속쉼표() {
        String input = "a,bcd,,ef,g";
        String[] carNames = input.split(",");
        assertThatThrownBy(() -> validation.validateCarNames(carNames)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_입력_검증_테스트_예외문자_공백() {
        String input = "a, b, c";
        assertThatThrownBy(() -> validation.validateInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_입력_검증_테스트_예외문자_숫자() {
        String input = "a,1b,0c";
        assertThatThrownBy(() -> validation.validateInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_입력_검증_테스트_예외문자_특수문자() {
        String input = "a,b,@c";
        assertThatThrownBy(() -> validation.validateInput(input)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 사용자_입력_검증_테스트_5자이상() {
        String input = "abcdefg,b,c";
        String[] carNames = input.split(",");
        assertThatThrownBy(() -> validation.validateLength(carNames)).isInstanceOf(IllegalArgumentException.class);
    }
}

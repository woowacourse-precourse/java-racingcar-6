package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidationTest {
    @Test
    void 정상_입력() {
        assertDoesNotThrow(() -> InputValidation.validateInput("tayo"));
        assertDoesNotThrow(() -> InputValidation.validateInput("tayo,gani"));
    }

    @Test
    void 문자열_처음에_숫자_입력_시_예외_처리() {
        assertThatThrownBy(() -> InputValidation.validateInput("2tayo"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_사이에_숫자_입력_시_예외_처리() {
        assertThatThrownBy(() -> InputValidation.validateInput("ta2yo"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_마지막에_숫자_입력_시_예외_처리() {
        assertThatThrownBy(() -> InputValidation.validateInput("tayo2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 쉼표_외_특수문자_입력_시_예외_처리() {
        assertThatThrownBy(() -> InputValidation.validateInput("tayo!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_입력_시_예외_처리() {
        assertThatThrownBy(() -> InputValidation.validateInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_5자_초과_시_예외_처리() {
        List<String> test = new ArrayList<>();
        test.add("tayooo");
        assertThatThrownBy(() -> InputValidation.validateCarNames(test))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
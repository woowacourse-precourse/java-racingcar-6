package racingcar.utilTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputValidation;

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

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void 이동횟수_정상_입력_테스트(String test) {
        assertDoesNotThrow(() -> InputValidation.validateMoveCount(test));
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    void 이동횟수에_공백이_입력된_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateMoveCount(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0"})
    void 이동횟수에_0이_입력된_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateMoveCount(test))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
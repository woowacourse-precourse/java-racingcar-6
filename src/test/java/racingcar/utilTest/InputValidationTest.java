package racingcar.utilTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.InputValidation;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"tayo", "gani"})
    void 자동차_이름_정상_입력_테스트(String test) {
        assertDoesNotThrow(() -> InputValidation.validateInput(test));
    }

    @ParameterizedTest
    @ValueSource(strings = {"tayo1", "1tayo", "ta1yo"})
    void 자동차_이름에_숫자가_입력된_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateInput(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"tayo!", "tayo*", "tayo-", "ta_yo", "tayo~", "?"})
    void 자동차_이름에_쉼표_외_특수문자가_입력된_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateInput(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "")
    void 자동차_이름에_공백이_입력된_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateInput(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"tayooo", "gani"})
    void 자동차_이름이_5자_초과한_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateCarNames(List.of(test)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"tayo", "tayo"})
    void 자동차_이름이_중복되는_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateCarNames(List.of(test)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "tayo")
    void 자동차_이름을_하나만_입력한_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateCarNames(List.of(test)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void 이동횟수_정상_입력_테스트(String test) {
        assertDoesNotThrow(() -> InputValidation.validateMoveCount(test));
    }

    @ParameterizedTest
    @ValueSource(strings = {"two"})
    void 이동횟수_입력_시_숫자가_아닌_경우_예외_처리(String test) {
        assertThatThrownBy(() -> InputValidation.validateMoveCount(test))
                .isInstanceOf(IllegalArgumentException.class);
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
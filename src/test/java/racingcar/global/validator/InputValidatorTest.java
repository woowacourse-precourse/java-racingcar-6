package racingcar.global.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.global.enums.ExceptionMessage.NON_NUMERIC_INPUT_ERROR_MESSAGE;
import static racingcar.global.enums.ExceptionMessage.NULL_OR_EMPTY_INPUT_MESSAGE;
import static racingcar.global.validator.InputValidator.validateInputIsNumeric;
import static racingcar.global.validator.InputValidator.validateNullOrEmptyInput;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 빈_문자_입력_예외_테스트() {
        //given
        String input = "";

        //when and then
        assertThatThrownBy(() -> validateNullOrEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_INPUT_MESSAGE.getMessage());
    }

    @Test
    void NULL_입력_예외_테스트() {
        //given
        String input = null;

        //when and then
        assertThatThrownBy(() -> validateNullOrEmptyInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_INPUT_MESSAGE.getMessage());
    }

    @Test
    void 숫자_외의_입력_예외_테스트() {
        //given
        String input = "1a3";

        //when and then
        assertThatThrownBy(() -> validateInputIsNumeric(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_NUMERIC_INPUT_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 정상_입력_테스트() {
        //given
        String input = "User Input";

        //when and then
        assertDoesNotThrow(() -> validateNullOrEmptyInput(input));
    }

    @Test
    void 숫자_입력_정상_테스트() {
        //given
        String input = "12";

        //when and then
        assertDoesNotThrow(() -> validateInputIsNumeric(input));
    }

}
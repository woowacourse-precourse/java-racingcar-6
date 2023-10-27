package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racingcar.enums.Constant.MAX_NAME_LENGTH;
import static racingcar.enums.ExceptionMessage.EXCEED_MAX_LENGTH_MESSAGE;
import static racingcar.enums.ExceptionMessage.NON_NUMERIC_INPUT_ERROR_MESSAGE;
import static racingcar.enums.ExceptionMessage.NULL_OR_EMPTY_INPUT_MESSAGE;
import static racingcar.validator.InputValidator.validateNameLength;
import static racingcar.validator.InputValidator.validateNullOrEmptyInput;
import static racingcar.validator.InputValidator.validateTryCount;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
    void 이름_길이_예외_테스트() {
        //given
        // 예외 발생을 위해 허용 되는 수치에 1을 더함
        int length = MAX_NAME_LENGTH.getConstant() + 1;
        String input = IntStream.range(0, length)
                .mapToObj(i -> "a")
                .collect(Collectors.joining());

        //when and then
        assertThatThrownBy(() -> validateNameLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXCEED_MAX_LENGTH_MESSAGE.getMessage());
    }

    @Test
    void 숫자_외의_입력_예외_테스트() {
        //given
        String input = "1a3";

        //when and then
        assertThatThrownBy(() -> validateTryCount(input))
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
    void 이름_길이_정상_테스트() {
        //given
        int length = MAX_NAME_LENGTH.getConstant();
        String input = IntStream.range(0, length)
                .mapToObj(i -> "a")
                .collect(Collectors.joining());

        //when and then
        assertDoesNotThrow(() -> validateNameLength(input));
    }

    @Test
    void 숫자_입력_정상_테스트() {
        //given
        String input = "12";

        //when and then
        assertDoesNotThrow(() -> validateTryCount(input));
    }

}
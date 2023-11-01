package racingcar.unit.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tdd.config.ErrorMessage.INPUT_CAR_NAME_COMMA_ERROR_MESSAGE;
import static tdd.config.ErrorMessage.INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE;

import org.junit.jupiter.api.Test;
import tdd.validator.InputCarNameValidator;
import tdd.validator.Validator;

public class InputCarNameValidatorTest {
    Validator<String> inputCarNameValidator = new InputCarNameValidator();
    private final String lengthErrorMessage = INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage();
    private final String commaErrorMessage = INPUT_CAR_NAME_COMMA_ERROR_MESSAGE.getMessage();
    private void assertThrowExceptionTest(String errorMessage, String input) {
        assertThatThrownBy(() -> inputCarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    private void assertNotThrowExceptionTest(String input) {
        assertThatCode(() -> inputCarNameValidator.validate(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 입력값이_최대_범위_넘어서면_예외처리_발생해서_통과() {
        String carName = "a";
        String input = carName.repeat(100001);
        assertThrowExceptionTest(lengthErrorMessage, input);
    }

    @Test
    void 입력값이_최소_범위_아래이면_예외처리_발생해서_통과() {
        String carName = "";
        assertThrowExceptionTest(lengthErrorMessage, carName);
    }

    @Test
    void 입력값이_범위_안이면_예외처리_발생_안해서_통과() {
        String carName = "a";
        String input = carName.repeat(100000);
        assertNotThrowExceptionTest(input);
    }

    @Test
    void 입력값의_처음에_콤마_있으면_예외처리_발생해서_통과() {
        String carName = ",a,asb";
        assertThrowExceptionTest(commaErrorMessage, carName);
    }

    @Test
    void 입력값의_마지막에_콤마_있으면_예외처리_발생해서_통과() {
        String carName = "a,asb,";
        assertThrowExceptionTest(commaErrorMessage, carName);
    }

    @Test
    void 입력값의_처음과_마지막에_콤마_있으면_예외처리_발생해서_통과() {
        String carName = ",a,asb,";
        assertThrowExceptionTest(commaErrorMessage, carName);
    }

    @Test
    void 입력값의_처음과_마지막에_콤마_없으면_예외처리_발생해서_통과() {
        String carName = "a,asb,c,d,e,f,g,10";
        assertNotThrowExceptionTest(carName);
    }
}

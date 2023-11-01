package tdd.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tdd.config.ErrorMessage.INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE;
import org.junit.jupiter.api.Test;

public class InputCarNameValidatorTest {
    Validator<String> inputCarNameValidator = new InputCarNameValidator();
    private void assertExceptionTest(String errorMessage, String input) {
        assertThatThrownBy(() -> inputCarNameValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }
    @Test
    void 입력값이_범위_넘어서면_예외처리_발생해서_통과() {
        String input = "a";
        assertExceptionTest(INPUT_CAR_NAME_LENGTH_ERROR_MESSAGE.getMessage(), input.repeat(100001));
    }
}

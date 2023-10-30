package validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validator.InputValidator;
import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    void 자동차이름_빈칸_입력() {
        assertThatThrownBy(() -> validator.checkCarNameValidate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);
    }

    @Test
    void 시도횟수_빈칸_입력() {
        assertThatThrownBy(() -> validator.checkNumOfAttempt(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {",a", "abc,", ",,,"})
    void 자동차이름_0자일_경우(String input) {
        assertThatThrownBy(() -> validator.checkCarNameValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);
    }

    @Test
    void 자동차이름_5자_초과한_경우() {
        assertThatThrownBy(() -> validator.checkCarNameValidate("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.CAR_NAME_EXCEED_FIVE_WORDS);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a, bc", "abc "," , , "})
    void 자동차이름_공백_포함된_경우(String input) {
        assertThatThrownBy(() -> validator.checkCarNameValidate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123a", "a", "five"})
    void 시도횟수_숫자가_아닌_문자_포함된_경우(String input) {
        assertThatThrownBy(() -> validator.checkNumOfAttempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.ATTEMPT_NUMBER_CONTAIN_CHAR_OTHER_THAN_NUMBER);
    }
}

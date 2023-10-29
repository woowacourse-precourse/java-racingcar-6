package racingcar.validator;

import org.junit.jupiter.api.Test;
import validator.InputValidator;
import static org.assertj.core.api.Assertions.*;

public class FunctionValidatorTest {
    private final InputValidator validator = new InputValidator();

    @Test
    void 자동차이름_빈칸_입력() {
        assertThatThrownBy(() -> validator.checkCarNameValidate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);
    }

    @Test
    void 시도회수_빈칸_입력() {
        assertThatThrownBy(() -> validator.checkNumOfAttempt(""))
                .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);
    }

    @Test
    void 자동차이름_0자일_경우() {
        assertThatThrownBy(() -> validator.checkCarNameValidate(",a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);

        assertThatThrownBy(() -> validator.checkCarNameValidate("abc,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);

        assertThatThrownBy(() -> validator.checkCarNameValidate(",,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);
    }

    @Test
    void 자동차이름_5자_초과한_경우() {
        assertThatThrownBy(() -> validator.checkCarNameValidate("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.CAR_NAME_EXCEED_FIVE_WORDS);
    }

    @Test
    void 자동차이름_공백_포함된_경우() {
        assertThatThrownBy(() -> validator.checkCarNameValidate(" a,bc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);

        assertThatThrownBy(() -> validator.checkCarNameValidate("abc "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);

        assertThatThrownBy(() -> validator.checkCarNameValidate(" , , "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.INPUT_CONTAIN_BLANK);
    }

    void 시도횟수_숫자가_아닌_문자_포함된_경우() {
        assertThatThrownBy(() -> validator.checkNumOfAttempt("123a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.ATTEMPT_NUMBER_CONTAIN_CHAR_OTHER_THAN_NUMBER);

        assertThatThrownBy(() -> validator.checkNumOfAttempt("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.ATTEMPT_NUMBER_CONTAIN_CHAR_OTHER_THAN_NUMBER);

        assertThatThrownBy(() -> validator.checkNumOfAttempt("five"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(validator.ATTEMPT_NUMBER_CONTAIN_CHAR_OTHER_THAN_NUMBER);


    }
}

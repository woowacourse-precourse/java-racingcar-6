package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {

    @Test
    void 자동차_이름이_5자리를_초과하면_예외발생() {
        assertThatThrownBy(() -> Validator.name_size_check(new String[]{"abcdef"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.OVER_NAME_SIZE.getMessage());
    }

    @Test
    void 자동차_이름이_중복되면_예외발생() {
        assertThatThrownBy(() -> Validator.name_duplication_check(new String[]{"hello", "hello"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATION_NAME.getMessage());
    }

    @Test
    void 자동차_이름을_입력하지_않으면_예외발생_공백() {
        assertThatThrownBy(() -> Validator.name_null_check(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NAME_NULL.getMessage());
    }

    @Test
    void 자동차_이름을_입력하지_않으면_예외발생_쉼표만_존재() {
        assertThatThrownBy(() -> Validator.name_null_check(","))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NAME_NULL.getMessage());
    }

    @Test
    void 자동차_이름_숫자_입력_예외발생() {
        assertThatThrownBy(() -> Validator.character_check("123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_STRING.getMessage());
    }

    @Test
    void 게임_진행횟수_숫자가_아닌값_입력_예외발생() {
        assertThatThrownBy(() -> Validator.number_check("열번"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_NUMBER.getMessage());
    }

    @Test
    void 게임_진행횟수_공백_입력_예외발생() {
        assertThatThrownBy(() -> Validator.number_check(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.NOT_NUMBER.getMessage());
    }
}

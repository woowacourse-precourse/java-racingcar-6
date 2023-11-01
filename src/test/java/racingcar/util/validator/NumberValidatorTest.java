package racingcar.util.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    private final Validator validator = NumberValidator.getInstance();

    @Test
    void 유효성_검사_통과() throws Exception {
        assertThatCode(() -> validator.validate("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void 유효성_검사_NULL_예외() throws Exception {
        assertThatThrownBy(() -> validator.validate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력 문자열은 null일 수 없습니다.");
    }

    @Test
    void 유효성_검사_문자_예외() throws Exception {
        assertThatThrownBy(() -> validator.validate("-123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }
}

package racingcar.input;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private static final String SPACE = " ";
    private static final String EMPTY = " ";
    private static final String BEFORETRIM = " po bi  ";
    private static final String AFTERTRIM = "po bi";
    @Test
    void 공백문자열시_에러() {
        assertThatThrownBy(() -> InputValidator.validate(SPACE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열입니다.");
    }

    @Test
    void 빈문자열시_에러() {
        assertThatThrownBy(() -> InputValidator.validate(EMPTY))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열입니다.");
    }

    @Test
    void 앞뒤_공백_제거_중간_공백은_제거하지_않음() {
        String afterTrim = InputValidator.validate(BEFORETRIM);
        assertThat(afterTrim)
                .isEqualTo(AFTERTRIM);
    }
}
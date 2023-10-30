package racingcar.Model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputCountValidatorTest {
    private static final InputCountValidator validator = new InputCountValidator();

    @Test
    void 최소_횟수_체크() {
        String input = "1";
        assertThat(validator.validateCount(input)).isEqualTo(1);
    }

    @Test
    void 최소_횟수_미만_체크() {
        String input = "0";
        assertThatThrownBy(() -> validator.validateCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 음수_체크() {
        String input = "-1";
        assertThatThrownBy(() -> validator.validateCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 문자열_체크() {
        String input = "a";
        assertThatThrownBy(() -> validator.validateCount(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"a\"");
    }

    @Test
    void 숫자_체크() {
        String input = "5";
        assertThat(validator.validateCount(input)).isEqualTo(5);
    }
}

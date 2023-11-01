package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.util.Validation;

public class ValidationTest {

    @Test
    void checkCarNameTest_메서드_사용시_문자열의_길이가_5이상일시_예외_발생() {
        String input = "abcdef";

        assertThatThrownBy(() -> Validation.checkCarName(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkTryNumber_메서드_사용시_문자열이_숫자가_아닐시_예외_발생() {
        String input = "abcdef";

        assertThatThrownBy(() -> Validation.checkTryNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

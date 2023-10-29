package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static racingcar.Validator.*;

class ValidatorTest {

    @Test
    void 입력한_숫자가_정수인지_검증_성공_케이스() {
        // given
        String input = "7";

        // when
        boolean result = isInteger(input);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 입력한_숫자가_정수인지_검증_실패_케이스() {
        // given
        String input = "number";

        // when
        boolean result = isInteger(input);

        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void 입력한_숫자가_양의_정수인지_검증_성공_케이스() {
        // given
        String input = "5";

        // when
        boolean result = isPositiveInteger(input);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 입력한_숫자가_양의_정수인지_검증_실패_케이스() {
        // given
        String input = "-7";

        // when
        boolean result = isPositiveInteger(input);

        // then
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void 입력에_공백이_없는지_검증한다_성공_케이스() {
        // given
        String input = "성겸,성민";

        // when
        boolean result = hasNoWhitespace(input);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 입력에_공백이_없는지_검증한다_실패_케이스() {
        // given
        String input = "성겸, 성민";

        // when
        boolean result = hasNoWhitespace(input);

        // then
        Assertions.assertThat(result).isFalse();
    }
}
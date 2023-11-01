package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RacingcarRoundConvertorTest {

    @Test
    void 올바른_문자열_숫자_정수_변환() {
        String input = "5";
        int result = RacingcarRoundConvertor.convert(input);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 올바르지_않은_문자열_입력시_예외_발생() {
        String input = "five";

        assertThatThrownBy(() -> RacingcarRoundConvertor.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력이 가능합니다.");
    }

    @Test
    void 비어있는_문자열_입력시_예외_발생() {
        String input = "";

        assertThatThrownBy(() -> RacingcarRoundConvertor.convert(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력이 가능합니다.");
    }
}

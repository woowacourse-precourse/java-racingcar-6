package strings;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import strings.util.Strings;

final class StringsTest {
    @DisplayName("Strings.repeat으로 입력한 횟수 만큼 문자열 반복 가능")
    @Test
    void repeatString() {
        // given
        final String input = "-";
        final int count = 10;

        // when
        final String repeated = Strings.repeat(input, count);

        // then
        assertThat(repeated).hasSize(count);
        assertThat(repeated).isEqualTo("----------");
    }

    @DisplayName("count가 음수일 경우 예외 발생")
    @Test
    void throwIfRepeatInNegativeTimes() {
        // given
        final String input = "-";
        final int count = -10;

        // when
        // then
        assertThatThrownBy(() ->
                Strings.repeat(input, count)
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("반드시 0회 이상 반복해야 합니다.");
    }
}
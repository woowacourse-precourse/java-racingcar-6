package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayCountInputTest {
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "10:10"}, delimiter = ':')
    void 입력받은_문자열을_파싱하여_객체를_생성한다(String input, int expectedPlayCount) {
        PlayCountInput playCountInput = PlayCountInput.parse(input);

        assertThat(playCountInput.playCount()).isEqualTo(expectedPlayCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "1a", "10%", "1a1", ""})
    void 파싱시_숫자가_아닌_문자열이_입력되면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> PlayCountInput.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

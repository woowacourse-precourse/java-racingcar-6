package racingcar.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputTest {
    @ParameterizedTest
    @CsvSource(value = {"' a ':a", "'\t  ':''", "a ! 1:a!1", "'a 1 \t ':a1"}, delimiter = ':')
    void trimmed_호출시_공백이_제거된_문자열이_반환된다(String rawInput, String expedtedTrimmedInput) {
        Input input = new Input(rawInput);

        assertThat(input.trimmed()).isEqualTo(expedtedTrimmedInput);
    }
}

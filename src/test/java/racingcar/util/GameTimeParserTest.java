package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTimeParserTest {
    private final char LEFT_BOUND = '0';
    private final char RIGHT_BOUND = '9';

    @ParameterizedTest
    @CsvSource(value = {"1,true", "a,false", ".,false", "9,true"})
    void 문자가_숫자인지_테스트(char testChar, boolean result) {
        assertThat(isNumber(testChar)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1123,1123", "11,11", "33,33"})
    void 문자열_숫자_파싱테스트(String testInput, boolean result) {
        int parsedInput = GameTimeParser.parse(testInput);

        assertThat(parsedInput).isEqualTo(parsedInput);
    }

    @ParameterizedTest
    @CsvSource(value = {"a123", "bb", "!ffc2"})
    void 문자열_숫자_파싱테스트_예외_IllegalException_발생(String testInput) {
        assertThatThrownBy(() -> GameTimeParser.parse(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력가능합니다.");
    }

    private boolean isNumber(char targetChar) {
        return LEFT_BOUND <= targetChar && targetChar <= RIGHT_BOUND;
    }
}
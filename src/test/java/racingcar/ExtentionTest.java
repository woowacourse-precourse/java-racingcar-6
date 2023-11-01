package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ExtentionTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi ", " pobi", "po bi"})
    void 문자열의_공백_삭제(String input) {
        String result = Extention.modify.removeSpace(input);
        assertThat(result).contains("pobi");
    }

    @Test
    void 문자열_마지막_콤마_삭제() {
        StringBuilder input = new StringBuilder("pobi, ");

        Extention.modify.removeLastComma(input);
        assertThat(input).contains("pobi");
    }
}
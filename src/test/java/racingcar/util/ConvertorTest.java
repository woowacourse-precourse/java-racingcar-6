package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConvertorTest {

    @DisplayName("문자열을 정수로 반환한다.")
    @ParameterizedTest
    @CsvSource({"123, 123", "01, 1"})
    void convertStringToInt(String input, int expected) {
        // when
        int number = Convertor.convertStringToInt(input);

        // then
        assertEquals(expected, number);
    }
}
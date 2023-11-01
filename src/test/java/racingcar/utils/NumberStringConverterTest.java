package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exceptions.runtime.InvalidNumberSourceException;

class NumberStringConverterTest {

    @Test
    @DisplayName("숫자 문자열을 숫자로 변환")
    void convert() {
        // given
        String number = "1";

        // when
        Long convertedNumber = NumberStringConverter.convert(number);

        // then
        assertEquals(convertedNumber, 1L);
    }

    @Test
    @DisplayName("숫자 문자열이 아니어 숫자로 변환할 수 없는 경우 예외 발생")
    void convertException() {
        // given
        String number = "a";

        // when

        // then
        assertThrows(InvalidNumberSourceException.class,
            () -> NumberStringConverter.convert(number));
    }
}
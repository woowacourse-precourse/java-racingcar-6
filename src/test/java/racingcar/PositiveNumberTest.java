package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositiveNumberTest {

    @CsvSource({ "123, 123, 10",
            "0, 0, 10",
            "203949, 203949, 10",
            "555555, 555555, 10",
            "abcdef, abcdef, 16",
            "1234ABC, 1234ABC, 16" })
    @ParameterizedTest
    void PositiveNumber_문자열_통해_생성_성공(String numberString, String expected, int expectedNumberType) {
        PositiveNumber givenNumber = PositiveNumber.fromString(numberString);
        Integer thenNumber = givenNumber.getNumber();
        assertThat(thenNumber).isEqualTo(Integer.parseInt(expected, expectedNumberType));
    }

    @CsvSource({ "-123",
            "-abc",
            "0xfff",
            "moo",
            "1.1",
            "-abcdef",
            "-ABCDEF", })
    @ParameterizedTest
    void PositiveNumber_문자열_통해_생성_실패(String numberString) {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> PositiveNumber.fromString(numberString))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]"));
    }

    @CsvSource({ "123, 123",
            "0, 0",
            "203949, 203949",
            "555555, 555555" })
    @ParameterizedTest
    void PositiveNumber_Integer_통해_생성_성공(Integer number, Integer expected) {
        PositiveNumber givenNumber = PositiveNumber.fromInteger(number);
        Integer thenNumber = givenNumber.getNumber();
        assertThat(thenNumber).isEqualTo(expected);
    }

    @CsvSource({ "123, 12, 1",
            "234, 203949, -1",
            "555555, 555555, 0" })
    @ParameterizedTest
    void PositiveNumber_비교(Integer given, Integer then, int expected) {
        PositiveNumber givenPositiveNumber = PositiveNumber.fromInteger(given);
        PositiveNumber thenPositiveNumber = PositiveNumber.fromInteger(then);
        assertThat(givenPositiveNumber.compareTo(thenPositiveNumber)).isEqualTo(expected);
    }

    @Test
    void PositiveNumber_1_증가() {
        PositiveNumber givenPositiveNumber = PositiveNumber.fromInteger(1);
        PositiveNumber expectedPositiveNumber = PositiveNumber.fromInteger(2);
        givenPositiveNumber.increase();
        assertThat(givenPositiveNumber).isEqualTo(expectedPositiveNumber);
    }

    @CsvSource({ "123, 122",
            "0, 0" })
    @ParameterizedTest
    void PositiveNumber_1_감소(Integer given, Integer then) {
        PositiveNumber givenPositiveNumber = PositiveNumber.fromInteger(given);
        PositiveNumber expectedPositiveNumber = PositiveNumber.fromInteger(then);
        givenPositiveNumber.decrease();
        assertThat(givenPositiveNumber).isEqualTo(expectedPositiveNumber);
    }

    @CsvSource({ "0, true",
            "1, false" })
    @ParameterizedTest
    void IsZero_구현(Integer given, boolean expected) {
        PositiveNumber givenPositiveNumber = PositiveNumber.fromInteger(given);
        boolean isZero = givenPositiveNumber.isZero();
        assertThat(isZero).isEqualTo(expected);
    }
}

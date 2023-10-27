package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumberOfAttemptsInputConverterTest {
    static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of("5", 5),
                Arguments.of("15", 15)
        );
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("validParameters")
    void test_convert_유효한_입력값일_경우_정수로_변환(String validInput, int expected) {
        int result = NumberOfAttemptsInputConverter.convert(validInput);
        assertEquals(expected, result);
    }

    static Stream<Arguments> inValidParameters() {
        return Stream.of(
                Arguments.of("a", "정수만 가능"),
                Arguments.of("0", "1이상 정수만 가능")
        );
    }

    @ParameterizedTest(name = "{0}: {1}")
    @MethodSource("inValidParameters")
    void test_convert_유효하지_않은_입력값일_경우_예외_발생(String invalidInput, String testName) {
        assertThrows(IllegalArgumentException.class,
                () -> NumberOfAttemptsInputConverter.convert(invalidInput));
    }
}

package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarNamesInputConverterTest {

    static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of("aa,bb,cc", List.of("aa", "bb", "cc")),
                Arguments.of("aa,bb", List.of("aa", "bb"))
        );
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("validParameters")
    void test_convert_유효한_입력값일_경우_리스트로_변환(String validInput, List<String> expected) {
        List<String> result = CarNamesInputConverter.convert(validInput);
        assertEquals(expected, result);
    }

    static Stream<Arguments> inValidParameters() {
        return Stream.of(
                Arguments.of("abcde,,bb,cc", "이름의 길이는 1 이상 5 이하만 가능"),
                Arguments.of("aaaaaa,bb,cc", "이름의 길이는 1 이상 5 이하만 가능"),
                Arguments.of("aa,aa,cc", "중복된 이름 불가")
        );
    }

    @ParameterizedTest(name = "{0}: {1}")
    @MethodSource("inValidParameters")
    void test_convert_유효하지_않은_입력값일_경우_예외_발생(String invalidInput, String testName) {
        assertThrows(IllegalArgumentException.class,
                () -> CarNamesInputConverter.convert(invalidInput));
    }
}

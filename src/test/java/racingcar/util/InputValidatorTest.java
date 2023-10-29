package racingcar.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InputValidatorTest {

    @ParameterizedTest
    @MethodSource("invalidCarNameInputProvider")
    public void 사용자_입력_자동차_이름_길이_테스트(String input, boolean expected) {
        assertThat(InputValidator.isValidCarNameLength(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("invalidGameCountInputProvider")
    public void 사용자_게임_횟수_테스트(String input, boolean expected) {
        assertThat(InputValidator.isNumeric(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> invalidCarNameInputProvider() { // argument source method
        return Stream.of(
                Arguments.of("", false),
                Arguments.of("1", true),
                Arguments.of("12", true),
                Arguments.of("123", true),
                Arguments.of("1234", true),
                Arguments.of("12345", true),
                Arguments.of("123456", false)
        );
    }

    private static Stream<Arguments> invalidGameCountInputProvider() { // argument source method
        return Stream.of(
                Arguments.of("", false),
                Arguments.of("-1", false),
                Arguments.of("1", true),
                Arguments.of("12", true),
                Arguments.of("a12A", false),
                Arguments.of("A12a", false)
        );
    }
}

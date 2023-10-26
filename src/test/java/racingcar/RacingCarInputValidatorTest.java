package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingCarInputValidatorTest {

    @ParameterizedTest
    @MethodSource("provideValidateCarNamesSuccessTestArguments")
    void validateCarNamesSuccessTest(List<String> names) {
        RacingCarInputValidator racingCarInputValidator = new RacingCarInputValidator();
        assertThatCode(() -> racingCarInputValidator.validateCarNames(names))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> provideValidateCarNamesSuccessTestArguments() {
        return Stream.of(
                arguments(List.of("java1", "JIGI2")),
                arguments(List.of("자바v", "test")),
                arguments(List.of("자바", "test")),
                arguments(List.of("한글12", "123"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidateCarNamesFailTestArguments")
    void validateCarNamesFailTest(List<String> names, String message) {
        RacingCarInputValidator racingCarInputValidator = new RacingCarInputValidator();
        assertThatCode(() -> racingCarInputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    static Stream<Arguments> provideValidateCarNamesFailTestArguments() {
        return Stream.of(
                arguments(List.of("", "asdasdsadsadas"), "자동차 이름은 최대 5자 이하만 가능합니다."),
                arguments(List.of("jㄹㅇ ", "!@#"), "자동차 이름은 한글, 영어, 숫자만 가능합니다."),
                arguments(List.of("ja va", ""), "자동차 이름은 한글, 영어, 숫자만 가능합니다."),
                arguments(List.of(" java", "    "), "자동차 이름은 한글, 영어, 숫자만 가능합니다.")
        );
    }
}

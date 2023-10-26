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
                arguments(List.of("java1", "jigi2")),
                arguments(List.of("자바v", "test")),
                arguments(List.of("자바", "test")),
                arguments(List.of("한글12", "123"))
        );
    }

    static Stream<Arguments> provideValidateCarNamesFailTestArguments() {
        return Stream.of(
                arguments(List.of("jㄹㅇ ", "!@#")),
                arguments(List.of("ja va", "")),
                arguments(List.of(" java", "    "))
        );
    }
}

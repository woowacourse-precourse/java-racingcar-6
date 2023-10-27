package racingcar.model;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.CarNamesValidator;

public class CarNamesValidatorTest {
    private CarNamesValidator validator;

    @ParameterizedTest
    @ValueSource(strings = "pobi,woni,jun")
    void 문자열을_입력_받으면_콤마로_구분(String inputNames) {
        String[] carNames = inputNames.split(",");

        Assertions.assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    private static Stream<Arguments> generateValidNames() {
        return Stream.of(
                Arguments.of("pobic,wis,j"),
                Arguments.of("p,wiss,j"),
                Arguments.of("po,wi,julic")
        );
    }

    private static Stream<Arguments> generateUnvalidNames() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("sun,kingking"),
                Arguments.of("pobils,sun hun"),
                Arguments.of("SayLoud,a1bcChocolate"),
                Arguments.of("한국이름,입력,방지")
        );
    }

    @ParameterizedTest
    @MethodSource("generateValidNames")
    void 문제_없는_문자열_검증(String inputNames) {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> new CarNamesValidator(inputNames));
    }

    @ParameterizedTest
    @MethodSource("generateUnvalidNames")
    void 조건에_맞지_않는_문자열_예외(String inputNames) {
        Assertions.assertThatThrownBy(() -> new CarNamesValidator(inputNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

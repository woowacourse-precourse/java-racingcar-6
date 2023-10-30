package racingcar.utils.validators;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

class CarNamesValidatorTest {
    @ParameterizedTest(name = "{0}")
    @MethodSource("Parameters")
    @DisplayName("자동차 이름 검증")
    void checkCarNames(String testName, String carNames) {
        Assertions.assertThatThrownBy(() -> CarNamesValidator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> Parameters() {
        return Stream.of(
                Arguments.of("길이 초과", "Hot, HotFriedDelicious"),
                Arguments.of("길이 0", "Hot,"),
                Arguments.of("공백", "Hot, "),
                Arguments.of("빈 값", ""),
                Arguments.of("중복된 자동차명", "Fried, Fried")
        );
    }

    @Test
    @DisplayName("예외 발생X")
    void noExceptionThrown() {
        assertThatCode(() -> CarNamesValidator.validateCarNames("Hot, Fried, Chick"))
                .doesNotThrowAnyException();
    }
}
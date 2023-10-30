package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.controller.Validator;

public class ValidatorTest extends ApplicationTest {
    @ParameterizedTest
    @MethodSource("generateInvalidCarNames")
    void 이름_유효성_실패_테스트(List<String> carNames) {
        assertThrows(IllegalArgumentException.class,
                () -> Validator.validateCarNames(carNames));
    }

    @ParameterizedTest
    @MethodSource("generateValidCarNames")
    void 이름_유효성_성공_테스트(List<String> carNames) {
        assertDoesNotThrow(() -> Validator.validateCarNames(carNames));
    }

    static Stream<Arguments> generateInvalidCarNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "pobi", "woni")),
                Arguments.of(Arrays.asList("pobi", "jjjjun")),
                Arguments.of(Arrays.asList("", ""))
        );
    }

    static Stream<Arguments> generateValidCarNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni", "jun")),
                Arguments.of(Arrays.asList("pobi", "shu")),
                Arguments.of(Arrays.asList("jjjun", "pobi"))
        );
    }

    @ParameterizedTest
    @CsvSource({
            "d",
            "q"
    })
    void 시도할_횟수_유효성_실패_테스트(String tryCount) {
        assertThrows(IllegalArgumentException.class,
                () -> Validator.validateTryCountNumeric(tryCount));
    }

    @Test
    void 시도할_횟수_공백_확인() {
        assertThrows(IllegalArgumentException.class,
                () -> Validator.validateTryCountNumeric(""));
    }
}

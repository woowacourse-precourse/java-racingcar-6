package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.controller.Validator;

public class ValidatorTest extends ApplicationTest {
    @ParameterizedTest
    @MethodSource("generateInvalidNames")
    void 이름_유효성_실패_테스트(List<String> names) {
        assertThrows(IllegalArgumentException.class,
                () -> Validator.validateNames(names));
    }

    @ParameterizedTest
    @MethodSource("generateValidNames")
    void 이름_유효성_성공_테스트(List<String> names) {
        assertDoesNotThrow(() -> Validator.validateNames(names));
    }

    static Stream<Arguments> generateInvalidNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "pobi", "woni")),
                Arguments.of(Arrays.asList("pobi", "jjjjun")),
                Arguments.of(Arrays.asList("", ""))
        );
    }

    static Stream<Arguments> generateValidNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni", "jun")),
                Arguments.of(Arrays.asList("pobi", "shu")),
                Arguments.of(Arrays.asList("jjjun", "pobi"))
        );
    }
}

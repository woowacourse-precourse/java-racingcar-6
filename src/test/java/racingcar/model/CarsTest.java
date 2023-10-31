package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {
    @ParameterizedTest
    @MethodSource("generateInvalidCarNames")
    void 이름_유효성_실패_테스트(List<String> carNames) {
        assertThrows(IllegalArgumentException.class,
                () -> Cars.createCars(carNames));
    }

    @ParameterizedTest
    @MethodSource("generateValidCarNames")
    void 이름_유효성_성공_테스트(List<String> carNames) {
        assertDoesNotThrow(
                () -> Cars.createCars(carNames));
    }

    static Stream<Arguments> generateInvalidCarNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "pobi", "woni")),
                Arguments.of(Arrays.asList("pobi", "pobi", "pobi"))
        );
    }

    static Stream<Arguments> generateValidCarNames() {
        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "woni", "jun")),
                Arguments.of(Arrays.asList("pobi", "shu"))
        );
    }
}

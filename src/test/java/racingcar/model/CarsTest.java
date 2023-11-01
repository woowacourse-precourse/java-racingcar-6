package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.model.Cars.createCars;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @ParameterizedTest
    @MethodSource("generateInvalidCarNames")
    void 이름_유효성_실패_테스트(List<String> carNames) {
        assertThrows(IllegalArgumentException.class,
                () -> createCars(carNames));
    }

    @ParameterizedTest
    @MethodSource("generateValidCarNames")
    void 이름_유효성_성공_테스트(List<String> carNames) {
        assertDoesNotThrow(
                () -> createCars(carNames));
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

    @Test
    void 가장_먼_거리_테스트() {
        Cars cars = createCars(Arrays.asList("test1", "test2"));
        Assertions.assertRandomNumberInRangeTest(
                () -> {
                    cars.moveAll();
                    assertEquals(1, cars.getMaxDistance());
                },
                MOVING_FORWARD, STOP
        );
    }
}

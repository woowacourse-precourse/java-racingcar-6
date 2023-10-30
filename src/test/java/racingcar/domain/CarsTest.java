package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RacingcarTestConstantUtils.MIN_MOVING_FORWARD;
import static racingcar.utils.RacingcarTestConstantUtils.MIN_STOP;
import static racingcar.utils.RacingcarTestConstantUtils.MOVE_FAIL;
import static racingcar.utils.RacingcarTestConstantUtils.MOVE_SUCCESS;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
    private Car pobiCar;
    private Car woniCar;
    private Cars cars;

    private static Stream<Arguments> testMoveCountAndRandomNumber() {
        return Stream.of(
                Arguments.of(MOVE_FAIL, MOVE_FAIL, MIN_STOP, MIN_STOP),
                Arguments.of(MOVE_SUCCESS, MOVE_FAIL, MIN_MOVING_FORWARD, MIN_STOP),
                Arguments.of(MOVE_FAIL, MOVE_SUCCESS, MIN_STOP, MIN_MOVING_FORWARD),
                Arguments.of(MOVE_SUCCESS, MOVE_SUCCESS, MIN_MOVING_FORWARD, MIN_MOVING_FORWARD)
        );
    }

    @BeforeEach
    void setUp() {
        // given
        pobiCar = new Car("pobi");
        woniCar = new Car("woni");
        cars = new Cars(Arrays.asList(pobiCar, woniCar));
    }

    @ParameterizedTest
    @MethodSource("testMoveCountAndRandomNumber")
    void move_테스트(int expectedPobiMoveCount, int expectedWoniMoveCount, int pobiRandomNumber, int woniRandomNumber) {
        // when
        assertRandomNumberInRangeTest(
                () -> {
                    cars.move();
                    int pobiMoveCount = pobiCar.getMoveCount();
                    int woniMoveCount = woniCar.getMoveCount();
                    // then
                    assertThat(pobiMoveCount).isEqualTo(expectedPobiMoveCount);
                    assertThat(woniMoveCount).isEqualTo(expectedWoniMoveCount);
                },
                pobiRandomNumber, woniRandomNumber
        );
    }

    @ParameterizedTest
    @MethodSource("testMoveCountAndRandomNumber")
    void getMoveCountMap_테스트(int pobiMoveCount, int woniMoveCount, int pobiRandomNumber, int woniRandomNumber) {
        // given
        Map<String, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put("pobi", pobiMoveCount);
        expectedMap.put("woni", woniMoveCount);
        // when
        assertRandomNumberInRangeTest(
                () -> {
                    cars.move();
                    Map<String, Integer> moveCountMap = cars.getMoveCountMap();
                    // then
                    assertThat(moveCountMap).isEqualTo(expectedMap);
                },
                pobiRandomNumber, woniRandomNumber
        );
    }
}
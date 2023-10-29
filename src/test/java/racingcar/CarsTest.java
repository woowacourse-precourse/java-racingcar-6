package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;

class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int MOVEMENT_OCCURRED = 1;
    private static final int MOVEMENT_NOT_OCCURRED = 0;
    private Car pobiCar;
    private Car woniCar;
    private Cars cars;

    private static Stream<Arguments> testMoveCountAndRandomNumber() {
        return Stream.of(
                Arguments.of(MOVEMENT_NOT_OCCURRED, MOVEMENT_NOT_OCCURRED, STOP, STOP),
                Arguments.of(MOVEMENT_OCCURRED, MOVEMENT_NOT_OCCURRED, MOVING_FORWARD, STOP),
                Arguments.of(MOVEMENT_NOT_OCCURRED, MOVEMENT_OCCURRED, STOP, MOVING_FORWARD),
                Arguments.of(MOVEMENT_OCCURRED, MOVEMENT_OCCURRED, MOVING_FORWARD, MOVING_FORWARD)
        );
    }

    @BeforeEach
    void setUp() {
        pobiCar = new Car("pobi");
        woniCar = new Car("woni");
        cars = new Cars(Arrays.asList(pobiCar, woniCar));
    }

    @ParameterizedTest
    @MethodSource("testMoveCountAndRandomNumber")
    void move_테스트(int expectedPobiMoveCount, int expectedWoniMoveCount, int pobiRandomNumber, int woniRandomNumber) {
        assertRandomNumberInRangeTest(
                () -> {
                    cars.move();
                    int pobiMoveCount = pobiCar.getMoveCount();
                    int woniMoveCount = woniCar.getMoveCount();
                    assertThat(pobiMoveCount).isEqualTo(expectedPobiMoveCount);
                    assertThat(woniMoveCount).isEqualTo(expectedWoniMoveCount);
                },
                pobiRandomNumber, woniRandomNumber
        );
    }

    @ParameterizedTest
    @MethodSource("testMoveCountAndRandomNumber")
    void getMoveCountMap_테스트(int pobiMoveCount, int woniMoveCount, int pobiRandomNumber, int woniRandomNumber) {
        //given
        Map<String, Integer> expectedMap = new LinkedHashMap<>();
        expectedMap.put("pobi", pobiMoveCount);
        expectedMap.put("woni", woniMoveCount);
        //when, then
        assertRandomNumberInRangeTest(
                () -> {
                    cars.move();
                    Map<String, Integer> moveCountMap = cars.getMoveCountMap();
                    assertThat(moveCountMap).isEqualTo(expectedMap);
                },
                pobiRandomNumber, woniRandomNumber
        );
    }
}
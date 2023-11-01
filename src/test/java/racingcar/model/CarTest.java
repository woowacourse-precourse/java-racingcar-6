package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void tryMove_return_false(int mockValue) {
        Car car = new Car("name");
        assertRandomNumberInRangeTest(
                () -> Assertions.assertThat(car.isMove())
                        .isFalse(),
                mockValue
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void tryMove_return_true_when_4(int mockValue) {
        Car car = new Car("name");
        assertRandomNumberInRangeTest(
                () -> Assertions.assertThat(car.isMove())
                        .isTrue(),
                mockValue
        );
    }

    @ParameterizedTest
    @MethodSource("resultTestData")
    public void toStringTest1(int roundNumber, String result, int mockNumber, Integer[] mockNumbers) {
        assertRandomNumberInRangeTest(
                () -> Assertions.assertThat(moveCar("car", roundNumber))
                        .isEqualTo(result),
                mockNumber, mockNumbers
        );
    }

    private static Stream<Arguments> resultTestData() {
        return Stream.of(
                Arguments.of(3, "car : ---", 5, new Integer[]{4, 6}),
                Arguments.of(5, "car : --", 1, new Integer[]{2, 3, 4, 5}),
                Arguments.of(10, "car : ", 1, new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1})
        );
    }

    private String moveCar(String carName, int roundNum) {
        Car car = new Car(carName);
        for (int i = 0; i < roundNum; i++) {
            car.isMove();
        }
        return car.getRoundResult();
    }
}
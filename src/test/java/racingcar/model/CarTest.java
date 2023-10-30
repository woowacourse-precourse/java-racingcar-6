package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.model.Car.createNewCar;

import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 1-5글자이어야 함";


    @Test
    void Car_이름_길이_범위내_객체_생성_성공() {
        Car carWithMinNameLength = createNewCar("a".repeat(MIN_NAME_LENGTH));
        Car carWithMaxNameLength = createNewCar("b".repeat(MAX_NAME_LENGTH));
        assertThat(carWithMinNameLength).isInstanceOf(Car.class);
        assertThat(carWithMaxNameLength).isInstanceOf(Car.class);
    }

    @Test
    void Car_이름_길이_범위외_객체_생성_실패() {
        assertThatThrownBy(() -> {
            createNewCar("a".repeat(MAX_NAME_LENGTH + 1));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NAME_LENGTH_ERROR_MESSAGE);
    }

    @Test
    void Car_거리_비교() {
        assertRandomNumberInRangeTest(() -> {
            Car carWithDistanceOne = createNewCar("a".repeat(MIN_NAME_LENGTH));
            Car carWithDistanceTwo = createNewCar("b".repeat(MIN_NAME_LENGTH));

            carWithDistanceOne.updateDistance();
            carWithDistanceTwo.updateDistance();
            carWithDistanceTwo.updateDistance();

            assertThat(carWithDistanceOne.compareTo(carWithDistanceTwo)).isLessThan(0);
            assertThat(carWithDistanceTwo.compareTo(carWithDistanceOne)).isGreaterThan(0);
        }, MOVE_THRESHOLD);
    }

    @Test
    void 임계점_이상_전진() {
        assertRandomNumberInRangeTest(() -> {
            Car car = createNewCar("a".repeat(MIN_NAME_LENGTH));
            car.updateDistance();
            assertThat(car.getDistance()).isEqualTo(0);

            car.updateDistance();
            assertThat(car.getDistance()).isEqualTo(1);


        }, MOVE_THRESHOLD - 1, MOVE_THRESHOLD);
    }

}
package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumberGenerator;

class CarsTest {

    private static final int MAX_CARS_SIZE = 10;
    private static final int VALUE_FOR_MOVING_FORWARD = 5;
    private static final int VALUE_FOR_STOP = 2;

    @DisplayName("cars 생성 시 최소 자동차 개수보다 적으면 예외가 발생한다.")
    @Test
    void constructCars_Fail_BySizeIsLessThanMinimum() {
        // given
        Car carA = createCar("carA");

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(List.of(carA)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("cars 생성 시 최대 자동차 개수보다 많으면 예외가 발생한다.")
    @Test
    void constructCars_Fail_BySizeIsGreaterThanMaximum() {
        // given
        List<Car> createdCars = new ArrayList<>();
        for (int i = 0; i < MAX_CARS_SIZE + 1; i++) {
            createdCars.add(createCar("car" + i));
        }

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(createdCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("cars 생성 시 중복되는 이름이 존재하면 예외가 발생한다.")
    @Test
    void construct_Fail_ByDuplicatedCarName() {
        // given
        Car carA = createCar("carA");
        Car carB = createCar("carB");
        Car carC = createCar("carA");

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(List.of(carA, carB, carC)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 경주를 실행한 결과에서 자동차 이름과 전진 횟수 리스트는 기대한 값과 같다.")
    @Test
    void handleCarMovement_Success() {
        // given
        Cars cars = create3Cars();

        // when, then
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                () -> {
                    MovingResult movingResult = cars.handleCarMovement(new RandomNumberGenerator());
                    Assertions.assertThat(movingResult.carNames()).isEqualTo(List.of("car1", "car2", "car3"));
                    Assertions.assertThat(movingResult.forwardCounts()).isEqualTo(List.of(1, 0, 1));
                },
                VALUE_FOR_MOVING_FORWARD, VALUE_FOR_STOP, VALUE_FOR_MOVING_FORWARD
        );
    }

    @DisplayName("가장 많이 전진한 자동차가 2대라면, 가장 많이 전진한 자동차 목록을 조회했을 때 그 목록의 크기는 2다.")
    @Test
    void getCarsWithMaxForwardCount_Success() {
        // given
        Cars cars = create3Cars();

        // when, then
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                () -> {
                    cars.handleCarMovement(new RandomNumberGenerator());
                    List<Car> carsWithMaxForwardCount = cars.getCarsWithMaxForwardCount();
                    Assertions.assertThat(carsWithMaxForwardCount.size()).isEqualTo(2);
                },
                VALUE_FOR_STOP, VALUE_FOR_MOVING_FORWARD, VALUE_FOR_MOVING_FORWARD
        );
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    private Cars create3Cars() {
        List<Car> createdCars = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            createdCars.add(createCar("car" + i));
        }
        return new Cars(createdCars);
    }
}

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

    @DisplayName("cars 생성 시 최소 자동차 개수보다 적으면 예외가 발생한다.")
    @Test
    void constructCars_Fail_BySizeIsLessThanMinimum() {
        // given
        Car carA = new Car("carA");

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(List.of(carA)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("cars 생성 시 최대 자동차 개수보다 많으면 예외가 발생한다.")
    @Test
    void constructCars_Fail_BySizeIsGreaterThanMaximum() {
        // given
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < MAX_CARS_SIZE + 1; i++) {
            carList.add(new Car("car" + i));
        }

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("cars 생성 시 중복되는 이름이 존재하면 예외가 발생한다.")
    @Test
    void construct_Fail_ByDuplicatedCarName() {
        // given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carA");

        // when, then
        Assertions.assertThatThrownBy(() -> new Cars(List.of(carA, carB, carC)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 경주를 실행한 결과에서 자동차 이름과 전진 횟수 리스트는 기대한 값과 같다.")
    @Test
    void handleCarMovement_Success() {
        // given
        List<Car> carList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            carList.add(new Car("car" + i));
        }
        Cars cars = new Cars(carList);

        // when, then
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                () -> {
                    MovingResult movingResult = cars.handleCarMovement(new RandomNumberGenerator());
                    Assertions.assertThat(movingResult.carNames()).isEqualTo(List.of("car1", "car2", "car3"));
                    Assertions.assertThat(movingResult.forwardCounts()).isEqualTo(List.of(1, 0, 1));
                },
                5, 2, 5
        );
    }

    @DisplayName("가장 많이 전진한 자동차가 1대라면, 가장 많이 전진한 자동차 목록을 조회했을 때 그 목록의 크기는 1이다.")
    @Test
    void getCarsWithMaxForwardCount_Success() {
        // given
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");
        Cars cars = new Cars(List.of(carA, carB, carC));

        for (int i = 0; i < 2; i++) {
            carA.move(VALUE_FOR_MOVING_FORWARD);
        }

        // when
        List<Car> carsWithMaxForwardCount = cars.getCarsWithMaxForwardCount();

        // then
        Assertions.assertThat(carsWithMaxForwardCount.size()).isEqualTo(1);
    }
}

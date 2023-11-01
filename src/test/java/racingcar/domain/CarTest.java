package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("자동차 생성")
    public void create() {
        String carName = "car1";

        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차 전진")
    public void move() {
        String carName = "car1";
        Car car = new Car(carName);

        car.go();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 전진 조건 기준 미만")
    public void stopPositionCondition() {
        Cars cars = new Cars("car1,car2,car3");
        List<Integer> randomNumbers = List.of(1, 2, 3);

        cars.goOrStop(randomNumbers);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }

    }

    @Test
    @DisplayName("자동차 전진 조건 기준 이상")
    public void goPositionCondition() {
        Cars cars = new Cars("car1,car2,car3");
        List<Integer> randomNumbers = List.of(4, 5, 9);

        cars.goOrStop(randomNumbers);

        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
}
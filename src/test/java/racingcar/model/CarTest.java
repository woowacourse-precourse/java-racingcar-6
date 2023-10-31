package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.service.StubMovementStrategy;

class CarTest {


    @Test
    void 자동차_멈춤_테스트() {
        Car car = new Car("a", 0, new StubMovementStrategy(1));
        Car movedCar = car.attemptMove();

        assertThat(movedCar.distance()).isEqualTo(0);
    }

    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("a", 0, new StubMovementStrategy(4));
        Car movedCar = car.attemptMove();

        assertThat(movedCar.distance()).isEqualTo(1);
    }

}
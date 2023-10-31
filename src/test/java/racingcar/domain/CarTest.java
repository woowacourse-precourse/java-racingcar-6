package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void tryMoveCarTest1() {
        Car car = new Car();
        for (int i = 0; i < 5; i++) {
            car.tryMoveCar();
        }
        int result = car.carPosition;
        assertThat(result).isBetween(1, 5);
    }

    @Test
    void tryMoveCarTest2() {
        Car car = new Car();
        for (int i = 0; i < 10; i++) {
            car.tryMoveCar();
        }
        int result = car.carPosition;
        assertThat(result).isBetween(1, 10);
    }

    @Test
    void tryMoveCarTest3() {
        Car car = new Car();
        for (int i = 0; i < 20; i++) {
            car.tryMoveCar();
        }
        int result = car.carPosition;
        assertThat(result).isBetween(1, 20);
    }
}
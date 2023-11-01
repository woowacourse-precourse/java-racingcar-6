package racingcar.domain;

import racingcar.domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    void createCarWithName() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    void carMoveForward() {
        Car car = new Car("test");
        car.tryMove(4);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void carStop() {
        Car car = new Car("test");
        car.tryMove(3);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}

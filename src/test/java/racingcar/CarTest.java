package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_전진_불가능() {
        Car car = new Car("gyubin");
        car.go(1);
        Assertions.assertThat(car.distance.size()).isEqualTo(0);
    }

    @Test
    void 자동차_전진_가능() {
        Car car = new Car("gyubin");
        car.go(4);
        Assertions.assertThat(car.distance.size()).isEqualTo(1);
    }
}
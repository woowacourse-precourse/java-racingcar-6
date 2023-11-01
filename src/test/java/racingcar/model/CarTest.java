package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("자동차");
    }

    @Test
    void 이동3() {
        for (int i = 0; i < 3; i++) {
            car.moveForward();
        }
        assertThat(car.getLocation()).isEqualTo(3);
    }

    @Test
    void 이동5_심볼() {
        for (int i = 0; i < 5; i++) {
            car.moveForward();
        }
        assertThat(car.getLocationSymbol()).isEqualTo("-----");
    }

}
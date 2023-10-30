package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("씽씽이");
    }

    @Test
    void 이동() {
        car.move(6);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 이동하지_않음() {
        car.move(1);
        Assertions.assertThat(car.getMoveCount()).isZero();
    }

    @Test
    void 이동_문자열() {
        car.move(7);
        car.move(7);
        String movement = car.generateMovement();
        Assertions.assertThat(movement).isEqualTo("--");
    }

}
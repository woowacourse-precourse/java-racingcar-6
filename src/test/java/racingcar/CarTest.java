package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    void Car_앞으로_전진() {
        car.move();
        assertThat(car.getScore()).isEqualTo(1);
    }

    @Test
    void Car_최초_점수_0() {
        assertThat(car.getScore()).isEqualTo(0);
    }
}
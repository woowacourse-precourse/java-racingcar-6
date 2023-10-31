package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("myCar");
    }

    @Test
    void moveZeroTest() {

        car.move(false);

        assertThat(car.getStatus()).isEmpty();
    }

    @Test
    void moveOneTest() {

        car.move(true);

        assertThat(car.getStatus()).isEqualTo("-");
    }

    @Test
    void moveTwoTest() {

        car.move(true);
        car.move(true);

        assertThat(car.getStatus()).isEqualTo("--");
    }
}
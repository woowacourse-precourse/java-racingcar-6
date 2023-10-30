package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    Car car;
    private static final String NAME = "pobi";
    private static final int POSITION = 0;

    @BeforeEach
    void setUp() {
        car = Car.of(NAME, POSITION);
    }

    @Test
    void createCar() {
        assertThat(car).isNotNull();
    }

    @Test
    void move() {
        car.move(4);
        assertThat(car).extracting("position").isEqualTo(1);
    }

    @Test
    void stop() {
        car.move(3);
        assertThat(car).extracting("position").isEqualTo(0);
    }

}

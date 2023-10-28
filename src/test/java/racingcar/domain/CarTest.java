package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    String name;
    Car car;

    @BeforeEach
    void setUp() {
        name = "default";
        car = new Car(name);
    }

    @Test
    void getDistance() {
        int result = car.getDistance();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getName() {
        String result = car.getName();
        assertThat(result).isEqualTo("default");
    }

    @Test
    void move() {
    }

    @Test
    void testToString() {
    }
}
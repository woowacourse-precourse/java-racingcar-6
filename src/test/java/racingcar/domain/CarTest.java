package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void getName() {
    }

    @Test
    void move() {
    }

    @Test
    void testToString() {
    }
}
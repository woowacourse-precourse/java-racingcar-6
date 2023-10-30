package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void forward() {
        Car car = new Car("pobi");

        car.forward();

        assertEquals(1, car.position);
    }

    @Test
    void stop() {
        Car car = new Car("pobi");

        car.stop();

        assertEquals(0, car.position);
    }
}
package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("carA");
    }

    @Test
    void moveCarTest() {
        int currentLocation = car.getCarLocation();
        car.moveCar();
        assertEquals(currentLocation + 1, car.getCarLocation());
    }
}

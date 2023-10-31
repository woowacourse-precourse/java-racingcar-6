package domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void carInitializationTest() {
        Car car = new Car("TestCar");
        assertEquals("TestCar", car.getName());
        assertEquals(0, car.getPosition());
    }
}

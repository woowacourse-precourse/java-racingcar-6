package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarCreation() {
        Car car = new Car("Test");
        assertNotNull(car);
        assertEquals("Test", car.getName());
        assertEquals(0, car.getDistance());
    }

    @Test
    public void testCarGoForward() {
        Car car = new Car("Test");
        car.goForward();
        assertEquals(1, car.getDistance());
    }
}

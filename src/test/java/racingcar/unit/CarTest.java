package racingcar.unit;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @Test
    public void testCarMove() {
        Car car = new Car("TestCar");
        car.move();
        assertEquals(1, car.getMoveDistance());
    }

    @Test
    public void testCarGetName() {
        Car car = new Car("TestCar");
        assertEquals("TestCar", car.getName());
    }
}

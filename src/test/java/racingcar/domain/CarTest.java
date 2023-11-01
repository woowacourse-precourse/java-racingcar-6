package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarConstructor() {
        Car car = new Car("TestCar");
        assertEquals("TestCar", car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    public void testCarMove() {
        Car car = new Car("TestCar");
        int initialPosition = car.getPosition();
        car.move();
        if (car.getPosition() > initialPosition) {
            assertEquals(initialPosition + 1, car.getPosition());
        } else {
            assertEquals(initialPosition, car.getPosition());
        }
    }
}

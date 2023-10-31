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

    @Test
    void moveForwardTest() {
        Car car = new Car("TestCar");
        car.moveForward(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    void moveForwardDistanceLessThanFourTest() {
        Car car = new Car("TestCar");
        car.moveForward(3);
        assertEquals(0, car.getPosition());
    }
}
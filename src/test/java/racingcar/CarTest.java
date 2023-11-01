package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void moveTest() {
        Car car = new Car("car1");

        assertEquals(0, car.getPosition());
        car.move();
        assertEquals(1, car.getPosition());
        car.move();
        assertEquals(2, car.getPosition());
    }

    @Test
    void getNameTest() {
        Car car = new Car("car2");

        assertEquals("car2", car.getName());
    }

    @Test
    void getPositionTest() {
        Car car = new Car("car3");

        assertEquals(0, car.getPosition());
    }
}
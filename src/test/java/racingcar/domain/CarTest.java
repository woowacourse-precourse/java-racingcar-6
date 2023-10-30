package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CarTest {
    @Test
    public void testCarConstructor() {
        Car car = new Car("poni");

        assertEquals("poni", car.getName());
        assertEquals(0, car.getDistance());
    }

    @Test
    public void test_move() {
        Car car = new Car("test");
        car.move();
        car.move();

        assertEquals(2, car.getDistance());
    }

    @Test
    public void test_generatedRandomNumber() {
        Car car = new Car("test");
        int randomNumber = car.generatedRandomNumber();

        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }
}


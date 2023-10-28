package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarTest {
    @Test
    public void testCarConstructor() {
        Car car = new Car("poni");

        assertEquals("poni", car.getName());
        assertEquals(0, car.getDistance());
    }
}


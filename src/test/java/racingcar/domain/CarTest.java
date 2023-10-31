package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void test_carConstructor() {
        Car car = new Car("poni");

        String expectedName = "poni";
        String actualName = car.getName();
        int expectedDistance = 0;
        int actualDistance = car.getDistance();

        assertEquals(expectedName, actualName);
        assertEquals(expectedDistance, actualDistance);
    }

    @Test
    public void test_move() {
        Car car = new Car("test");
        car.move();
        car.move();

        int expectedDistance = 2;
        int actualDistance = car.getDistance();

        assertEquals(expectedDistance, actualDistance);
    }
}


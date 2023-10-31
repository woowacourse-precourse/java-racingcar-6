package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @Test
    void getName() {
        assertEquals("TestCar", car.getName());
    }


    @Test
    void distanceTest() {
        car.setDistance("-");
        car.setDistance("+");
        assertEquals("-+", car.getDistance());
    }

    @Test
    void countTest() {
        car.setCount();
        car.setCount();
        assertEquals(2, car.getCount());
    }
}
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
    void 전진이_잘_되는지() {
        car.setDistance("-");
        car.setDistance("+");
        assertEquals("-+", car.getDistance());
    }

    @Test
    void 전진_횟수가_잘_올라가는지() {
        car.setCount();
        car.setCount();
        assertEquals(2, car.getCount());
    }
}
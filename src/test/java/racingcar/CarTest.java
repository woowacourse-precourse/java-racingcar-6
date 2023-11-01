package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void forward() {
        Car car = new Car("pobi");
        car.forward();
        assertEquals(1, car.getPosition());
    }

    @Test
    void getName() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.getName());
    }
}

package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void advance() {
        Car car = new Car("pobi");
        car.advance();
        assertEquals(1, car.getPosition());
    }

    @Test
    void getName() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.getName());
    }

}
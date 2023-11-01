package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
    @Test
    void move_ShouldIncreasePosition_WhenRandomNumberIsGreaterThanOrEqualToMOVING_POSITION() {
        Car car = new Car("test");
        car.move();
        assertTrue(car.getPosition() >= 0 && car.getPosition() <= 1);
    }
}
package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
    @Test
    void testMoveShouldIncreasePositionWhenRandomNumberIsGreaterThanFour() {
        Car car = new Car("pobi");
        car.move();
        assertTrue(car.getPosition() > 0);
    }

    @Test
    void testIstAtPositionShouldReturnTrueWhenPositionIsSame() {
        Car car = new Car("pobi");
        assertTrue(car.isAtPosition(0));
    }

    @Test
    void testIsAtPositionShouldReturnFalseWhenPositionIsDifferent() {
        Car car = new Car("pobi");
        assertFalse(car.isAtPosition(1));
    }
}

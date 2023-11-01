package racingcar;

import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    @Test
    public void testIsMovingForwardWithRandomNumberLessThanMOVING_FORWARD() {
        Car car = new Car("Car1");
        int randomNumber = 3; // 작은 값, MOVING_FORWARD(4)보다 작음
        boolean result = car.isMovingForward(randomNumber);
        assertFalse(result);
    }

    @Test
    public void testIsMovingForwardWithRandomNumberMoreThanMOVING_FORWARD() {
        Car car = new Car("Car2");
        int randomNumber = 6; //
        boolean result = car.isMovingForward(randomNumber);
        assertTrue(result);
    }
}

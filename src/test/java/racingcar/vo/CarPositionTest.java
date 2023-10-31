package racingcar.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPositionTest {

    @DisplayName("필드값이 동일하면 레코드는 동일하다.")
    @Test
    void carPosition_equality_test() {
        CarPosition carPosition1 = new CarPosition(200);
        CarPosition carPosition2 = new CarPosition(200);

        assertEquals(carPosition1, carPosition2);
    }

    @DisplayName("필드값이 동일하지 않으면 레코드는 동일하지 않다.")
    @Test
    void carPosition_not_equal_test() {
        CarPosition carPosition1 = new CarPosition(200);
        CarPosition carPosition2 = new CarPosition(300);

        assertNotEquals(carPosition1, carPosition2);
    }
}

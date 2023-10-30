package racingcar.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDistanceTest {

    @DisplayName("필드값이 동일하면 객체는 동일해야 한다.")
    @Test
    void carDistance_equality_test() {
        CarDistance carDistance1 = new CarDistance(200);
        CarDistance carDistance2 = new CarDistance(200);

        assertEquals(carDistance1, carDistance2);
    }

    @DisplayName("필드값이 동일하지 않으면 객체는 동일하지 않다.")
    @Test
    void carDistance_not_equal_test() {
        CarDistance carDistance1 = new CarDistance(200);
        CarDistance carDistance2 = new CarDistance(300);

        assertNotEquals(carDistance1, carDistance2);
    }
}

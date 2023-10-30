package racingcar.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarDistanceTest {

    @Test
    void carDistance_constructor_test() {
        CarDistance carDistance = new CarDistance(100);

        assertEquals(100, carDistance.distance());
    }

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

    @DisplayName("레코드의 이름과 각 필드의 이름 및 대괄호 안의 해당 값이 포함된 문자열을 반환한다.")
    @Test
    void carDistance_toString_test() {
        CarDistance carDistance = new CarDistance(150);

        assertEquals("CarDistance[distance=150]", carDistance.toString());
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("위치 반환 기능 테스트")
    @Test
    void testGetPosition() {
        int expected = 0;
        Car car = new Car("pobi");

        assertEquals(expected, car.getPosition());
    }
}

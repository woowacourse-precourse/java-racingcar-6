package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @DisplayName("위치 반환 기능 테스트")
    @Test
    void testGetPosition() {
        int expected = 0;

        assertEquals(expected, car.getPosition());
    }

    @DisplayName("자동차 전진 기능 테스트")
    @Test
    void testMoveForward() {
        int expected = 2;

        car.moveForward();
        car.moveForward();

        assertEquals(expected, car.getPosition());
    }
}

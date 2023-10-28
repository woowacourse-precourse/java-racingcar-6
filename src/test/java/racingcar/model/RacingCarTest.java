package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    private RacingCar car;

    @BeforeEach
    public void setUp() {
        car = new RacingCar("TestCar");
    }

    @Test
    @DisplayName("차 이동 검증")
    public void testMoveForward() {
        int initialDistance = car.getDistance();
        car.moveForward(5);
        assertEquals(initialDistance + 5, car.getDistance());
    }

    @Test
    @DisplayName("차 이름 검증")
    public void testGetName() {
        assertEquals("TestCar", car.getName());
    }

    @Test
    @DisplayName("차 이동거리 검증")
    public void testToString() {
        car.moveForward(3);
        assertEquals("TestCar : ---", car.toString());
    }
}
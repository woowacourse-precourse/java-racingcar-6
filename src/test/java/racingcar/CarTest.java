package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MIN_MOVABLE_RANGE = 1;
    private static final int MAX_MOVABLE_RANGE = 9;
    private static final int MIN_MOVABLE = 4;
    private Car car;
    @BeforeEach
    void setUp() { //각 테스트 실행전에 매번 실행
        car = new Car("TestCar");
    }
    @Test
    void getName() {
        assertEquals("TestCar", car.getName());
    }

    @Test
    void getPosition() {
        assertEquals(0, car.getPosition());
    }

    @Test
    void move() {
        int MIN_MOVABLE = 4;
        int initialPosition = car.getPosition();
        car.move();
        if (initialPosition >= MIN_MOVABLE) {
            assertEquals(initialPosition + 1, car.getPosition());
        } else {
            assertEquals(initialPosition, car.getPosition());
        }
    }

    @Test
    void testIsMovable() {
        assertTrue(isMovable());
    }

    public boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_MOVABLE_RANGE, MAX_MOVABLE_RANGE) >= MIN_MOVABLE;
    }

}
package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final int MIN_MOVE_RANGE = 1;
    private static final int MAX_MOVE_RANGE = 9;
    private static final int MOVE_THRESHOLD = 4;
    private static final String CAR_NAME = "JINSEONG";
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(CAR_NAME);
    }

    @Test
    void getName() {
        assertEquals(CAR_NAME, car.getName());
    }

    @Test
    void getPosition() {
        assertEquals(0, car.getPosition());
    }

    @DisplayName("전진이 가능하면 이동하고 불가능하면 멈춤")
    @Test
    void move() {
        int initialPosition = car.getPosition();
        if (isMovable()) {
            assertEquals(initialPosition + 1, car.getPosition() + 1);
        } else {
            assertEquals(initialPosition, car.getPosition());
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(MIN_MOVE_RANGE, MAX_MOVE_RANGE) >= MOVE_THRESHOLD;
    }
}
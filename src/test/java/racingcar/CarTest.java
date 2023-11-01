package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarTest {
    private static final int TEST_NUMBER = 5;
    private static final String TEST_NAME = "pobi";
    private Car car;

    @BeforeEach
    void 자동차_초기값_세팅() {
        car = new Car(TEST_NAME);
        for (int i = 0; i < TEST_NUMBER; i++) {
            car.upMoveCount();
        }
    }

    @Test
    void 자동차_이름_반환_확인() {
        assertEquals(TEST_NAME, car.getCarName());
    }

    @Test
    void 자동차_움직임_확인() {
        assertEquals(TEST_NUMBER, car.getMoveCount());
    }
}

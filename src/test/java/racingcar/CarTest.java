package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @DisplayName("자동차 이동 테스트")
    @Test
    void moveTest() {
        Car car = new Car("test");

        for (int i = 0; i < 5; i++) {
            car.move();
        }

        assertTrue(car.getPosition().length() >= 0 && car.getPosition().length() <= 5);
    }

}

package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    void 자동차_전진_테스트_4이상이면_전진() {
        Car car = new Car("car");

        while (car.getPosition() == 0) {
            car.move();
        }
        assertTrue(car.getPosition() > 0);
    }
}
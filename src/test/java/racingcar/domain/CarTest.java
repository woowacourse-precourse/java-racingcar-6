package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("move(): 차를 한 칸 이동시키는 기능")
    @Test
    void moveTest() {
        Car car = new Car("붕붕이");
        car.move();
        car.move();
        assertEquals(car.getProgressToInt(), 2);
    }
}

package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void testPlusMove() {
        Car car = new Car("yusm");
        car.plusMove();
        assertEquals(1, car.getMove());
    }

    @Test
    public void testInvalidCarName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("QWERTY는 5글자가 넘는데요?");
        });
    }
}

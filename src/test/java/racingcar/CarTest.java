package racingcar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    Car car1 = new Car("pobi");

    @Test
    @DisplayName("생성 테스트")
    public void getValueTest() {
        assertEquals("pobi", car1.getName());
    }

    @Test
    @DisplayName("plusCount 테스트")
    public void plusCountTest() {
        car1.move();
        assertEquals(1, car1.getCount());
    }
}

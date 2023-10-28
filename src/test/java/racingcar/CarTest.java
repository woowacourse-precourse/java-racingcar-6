package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_전진_테스트() {
        // given
        Car car = new Car("Car1");
        // when
        car.moveForward();
        // then
        Assertions.assertEquals(1, car.getForward());
    }
}

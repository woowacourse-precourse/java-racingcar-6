package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

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

    @Test
    public void 자동차_이름_테스트() {
        // given
        Car car = new Car("pobi");
        // when
        String name = car.getName();
        // then
        Assertions.assertEquals(name, car.getName());
    }
}

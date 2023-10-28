package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    @Test
    void 자동차_전진_기능_4미만이면_정지() {
        Car car = new Car("car1");
        Assertions.assertEquals(0, car.moves(0));
    }

    @Test
    void 자동차_전진_기능_4이상이면_전진() {
        Car car = new Car("car1");
        Assertions.assertEquals(1, car.moves(9));
    }
}

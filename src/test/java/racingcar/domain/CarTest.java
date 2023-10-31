package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_전진_기능_4미만이면_정지() {
        Car car = new Car("car");
        int start = car.getLocation();

        car.moves(0);

        Assertions.assertEquals(start, car.getLocation());
    }

    @Test
    void 자동차_전진_기능_4이상이면_전진() {
        Car car = new Car("car");
        int start = car.getLocation();

        car.moves(4);

        Assertions.assertEquals(start + 1, car.getLocation());
    }
}

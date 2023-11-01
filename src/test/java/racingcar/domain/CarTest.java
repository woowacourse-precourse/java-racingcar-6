package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차_전진() {
        Car pobi = Car.registerCar("pobi");
        Car forwardCar = Car.moveForwardCar(pobi);

        Assertions.assertEquals(pobi.getDistance(), 0);
        Assertions.assertEquals(forwardCar.getDistance(), 1);
    }

    @Test
    void 자동차_생성() {
        Car pobi = Car.registerCar("pobi");
        Assertions.assertEquals(pobi.getName(), "pobi");
    }
}
package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    public void testGo() {
        Car car = new Car("Car");
        int random = Util.getRandomNum();

        car.go();
        if (random >= 4) {
            assertEquals(1, car.getPosition());
        } else {
            assertEquals(0, car.getPosition());
        }
    }
}
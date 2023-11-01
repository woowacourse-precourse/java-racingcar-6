package racingcar.car.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.car.model.Car;
import racingcar.car.model.CarName;
import racingcar.car.model.RacingCar;

class CarTest {

    @Test
    void 자동차_생성() {
        String name = "Ford";
        CarName carName = new CarName(name);
        Car mustang = new RacingCar(carName);

        assertEquals(name, mustang.getName());
    }

    @Test
    void 자동차_전진() {
        String name = "Ford";
        CarName carName = new CarName(name);
        Car mustang = new RacingCar(carName);

        mustang.moveForward();

        assertEquals(1, mustang.getPosition());
    }

}
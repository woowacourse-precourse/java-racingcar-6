
package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarFactory;

public class CarFactoryTest {
    @Test
    void 새로운_자동차_인스턴스를_생성한다(){
        Car car1 = CarFactory.getNewCarInstance();
        Car car2 = CarFactory.getNewCarInstance();
        Assertions.assertNotEquals(car1,car2);
    }
}

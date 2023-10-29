package racingcar.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;

public class CarEqualsTest {

    @Test
    @DisplayName("Car의 동등성이 올바르게 판단된다.")
    void CarEqualsTest() {
        // given
        CarName carName1 = new CarName("차1");
        CarName carName2 = new CarName("차2");
        Car car1 = new Car(carName1);
        Car car2 = new Car(carName2);
        Car car3 = new Car(carName2);

        // when
        boolean expectedFalse = car1.equals(car2);
        boolean expectedTrue = car2.equals(car3);

        // then
        Assertions.assertFalse(expectedFalse);
        Assertions.assertTrue(expectedTrue);
    }

}

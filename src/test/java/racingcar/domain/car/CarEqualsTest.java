package racingcar.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.CarMovementStrategy;
import racingcar.domain.car.strategy.MoveForwardOnceRandomlyStrategy;

public class CarEqualsTest {

    @Test
    @DisplayName("Car의 동등성이 올바르게 판단된다.")
    void CarEqualsTest() {
        // given
        String carName1 = "차1";
        String carName2 = "차2";
        CarMovementStrategy carMovementStrategy = new MoveForwardOnceRandomlyStrategy();
        Car car1 = new Car(carName1, carMovementStrategy);
        Car car2 = new Car(carName2, carMovementStrategy);
        Car car3 = new Car(carName2, carMovementStrategy);

        // when
        boolean expectedFalse = car1.equals(car2);
        boolean expectedTrue = car2.equals(car3);

        // then
        Assertions.assertFalse(expectedFalse);
        Assertions.assertTrue(expectedTrue);
    }

}

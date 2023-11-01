package racingcar.domain.car;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.CarMovementStrategy;
import racingcar.domain.car.strategy.MoveForwardOnceRandomlyStrategy;

public class CarsGeneratorTest {

    @Test
    @DisplayName("CarsGenerator가 List<String>을 Car로 올바르게 변환한다.")
    void carsGeneratorTest() {
        // given
        String name1 = "차1";
        String name2 = "차2";
        String name3 = "차3";
        CarMovementStrategy carMovementStrategy = new MoveForwardOnceRandomlyStrategy();

        // when
        CarsGenerator carsGenerator = new CarsGenerator(carMovementStrategy);
        List<String> names = List.of(name1, name2, name3);
        Cars cars = carsGenerator.generateCarsFromNames(names);

        Cars expectedCars = new Cars(
                List.of(
                        new Car(name1, carMovementStrategy),
                        new Car(name2, carMovementStrategy),
                        new Car(name3, carMovementStrategy)
                )
        );

        // then
        Assertions.assertEquals(cars, expectedCars);
    }
}

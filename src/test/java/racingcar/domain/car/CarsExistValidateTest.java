package racingcar.domain.car;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.CarMovementStrategy;
import racingcar.domain.car.strategy.MoveForwardOnceStrategy;

public class CarsExistValidateTest {

    private final CarMovementStrategy carMovementStrategy = new MoveForwardOnceStrategy();
    private final CarsGenerator carsGenerator = new CarsGenerator(carMovementStrategy);

    @Test
    @DisplayName("차가 한 대라도 존재한다면 예외가 발생하지 않는다.")
    void carsValidateExistSuccessTest() {
        // given
        List<String> carNames = List.of("1");

        // then
        Assertions.assertDoesNotThrow(() -> {
            carsGenerator.generateCarsFromNames(carNames);
        });
    }

    @Test
    @DisplayName("차가 한 대라도 존재하지 않는다면 예외가 발생한다.")
    void carsValidateExistFailTest() {
        // given
        List<String> carNames = List.of();

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carsGenerator.generateCarsFromNames(carNames);
        });
    }

}

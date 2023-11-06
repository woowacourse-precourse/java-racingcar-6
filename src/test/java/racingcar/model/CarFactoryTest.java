package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.movingstrategy.RandomRacingCarMovingStrategy;

public class CarFactoryTest {

    @Test
    void 자동차_이름들로_RacingCars_객체를_생성할_수_있다() {
        CarFactory carFactoryWithMovingStrategy = CarFactory.createCarFactoryWithMovingStrategy(
            new RandomRacingCarMovingStrategy());
        List<String> carNames = List.of("carName1", "carName2");

        assertThat(carFactoryWithMovingStrategy.createRacingCarsByNames(carNames))
            .isInstanceOf(RacingCars.class);
    }
}

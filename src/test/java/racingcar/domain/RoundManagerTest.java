package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.data.Car;
import racingcar.domain.data.CarNames;
import racingcar.domain.data.Cars;
import racingcar.domain.data.RoundCount;
import racingcar.output.Output;

class RoundManagerTest {

    private RoundManager roundManager;
    private NumberGenerator numberGenerator;
    private Cars cars;
    private static final String CAR1_NAME = "pobi";
    private static final String CAR2_NAME = "woni";
    private static final String CAR3_NAME = "jun";
    private static final int FORWARD = 4;

    @BeforeEach
    void setUp() {
        CarNames carNames = new CarNames(Arrays.asList(CAR1_NAME, CAR2_NAME, CAR3_NAME));
        cars = new Cars(carNames);
        numberGenerator = () -> FORWARD;
        RoundCount roundCount = new RoundCount("3");
        roundManager = new RoundManager(cars, roundCount, numberGenerator, new Output());
    }

    @Test
    void run_메서드으로_각_차수마다_RacingCars의_자동차들을_자동차_전진조건을_판단해서_전진() {
        roundManager.runRounds();

        for (Car car : cars.getCars()) {
            assertThat(car.getForwardDistance())
                    .isEqualTo(3);
        }
    }
}
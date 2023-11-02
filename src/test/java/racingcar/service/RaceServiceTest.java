package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarManager;
import racingcar.view.Output;

public class RaceServiceTest {
    private CarManager carManager;
    private RaceService raceService;
    private Output output;

    @BeforeEach
    void setUp() {
        carManager = new CarManager();
        output = new Output();
        raceService = new RaceService(carManager, output);
    }
    @Test
    void nthAttemptTest_RunOnce_1MoveOrNot() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        carManager.createCarList(carNames);

        raceService.nthAttemptRace();

        List<Car> racingCars = carManager.readCarList();
        for (final Car car : racingCars) {
            int movingCount = car.getMovingCount();
            assertThat(movingCount).isGreaterThanOrEqualTo(0);
            assertThat(movingCount).isLessThanOrEqualTo(1);
        }
    }

    @Test
    void correctWinnersTest_SameMaxMoveValue() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        carManager.createCarList(carNames);

        carManager.readCarList().get(0).moveForward();
        carManager.readCarList().get(2).moveForward();

        List<String> winners = raceService.getWinners();
        assertThat(winners).contains("pobi", "jun");
        assertThat(winners).doesNotContain("woni");
    }
}

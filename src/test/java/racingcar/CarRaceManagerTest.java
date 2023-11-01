package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceManagerTest {
    private CarRaceManager raceManager;

    @BeforeEach
    void setUp() {
        raceManager = new CarRaceManager();
    }

    @Test
    void createCarList() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        raceManager.createCarList(carNames);

        List<Car> racingCars = raceManager.getRacingCars();
        assertThat(racingCars).hasSize(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            assertThat(racingCars.get(i).getCarName()).isEqualTo(carNames.get(i));
        }
    }

    @Test
    void getAttemptNumber() {
        int attemptNumber = raceManager.getAttemptNumber("5");
        assertThat(attemptNumber).isEqualTo(5);
    }

    @Test
    void nthAttemptRace() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        raceManager.createCarList(carNames);

        raceManager.nthAttemptRace();

        List<Car> racingCars = raceManager.getRacingCars();
        for (Car car : racingCars) {
            int movingCount = car.getMovingCount();
            assertThat(movingCount).isGreaterThanOrEqualTo(0);
            assertThat(movingCount).isLessThanOrEqualTo(1);
        }
    }

    @Test
    void getWinners() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        raceManager.createCarList(carNames);

        raceManager.getRacingCars().get(0).moveForward();
        raceManager.getRacingCars().get(2).moveForward();

        List<String> winners = raceManager.getWinners();
        assertThat(winners).contains("pobi", "jun");
        assertThat(winners).doesNotContain("woni");
    }
}
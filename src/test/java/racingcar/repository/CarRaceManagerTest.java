package racingcar.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceManagerTest {
    private CarManager raceManager;

    @BeforeEach
    void setUp() {
        raceManager = new CarManager();
    }

    @Test
    void createCarListTest_CompareWithArray_Equals() {
        List<String> carNames = List.of("pobi", "woni", "jun");

        raceManager.createCarList(carNames);

        List<Car> racingCars = raceManager.readCarList();
        assertThat(racingCars).hasSize(carNames.size());
        for (int index = 0; index < carNames.size(); index++) {
            assertThat(racingCars.get(index).getCarName()).isEqualTo(carNames.get(index));
        }
    }
}
package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

class RacingCarListTest {

    @Test
    void generateRacingCarList_리스트_생성_테스트() {
        String[] carNames = {"test", "car", "name"};

        List<RacingCar> result = RacingCarList.generateRacingCarList(carNames);

        assertThat(result.size()).isEqualTo(carNames.length);
    }

    @Test
    void generateRacingCarList_생성_리스트_차이름_테스트() {
        String[] carNames = {"test", "car", "name"};

        List<RacingCar> result = RacingCarList.generateRacingCarList(carNames);

        for (RacingCar racingCar : result) {
            assertThat(carNames).contains(racingCar.getCarName());
        }
    }

    @Test
    void moveAllRacingCarsForward_모든_자동차_전진_테스트() {
        String[] carNames = {"test", "car", "name"};

        List<RacingCar> racingCars = RacingCarList.generateRacingCarList(carNames);

        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getDistance()).isEqualTo(0);
        }

        for (int i = 0; i < 100; i++) {
            RacingCarList.moveAllRacingCarsForward(racingCars);
        }

        for (RacingCar racingCar : racingCars) {
            assertTrue(racingCar.getDistance() > 0);
        }
    }

}
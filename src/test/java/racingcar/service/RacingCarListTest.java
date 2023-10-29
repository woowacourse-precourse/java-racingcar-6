package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

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

}
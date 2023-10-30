package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

class RefereeTest {

    @Test
    void getMaxDistance_자동차_전진하기_전_테스트() {
        String[] carNames = {"test", "car", "name"};
        List<RacingCar> racingCars = RacingCarList.generateRacingCarList(carNames);

        int maxDistance = Referee.getMaxDistance(racingCars);
        assertThat(maxDistance).isEqualTo(0);
    }

    @Test
    void getMaxDistance_자동차_한대만_전진_후_테스트() {
        String[] carNames = {"test", "car", "name"};
        List<RacingCar> racingCars = RacingCarList.generateRacingCarList(carNames);

        for (int i = 0; i < 100; i++) {
            racingCars.get(0).moveForward();
        }

        int maxDistance = Referee.getMaxDistance(racingCars);
        assertThat(maxDistance).isNotEqualTo(0);
    }

    @Test
    void generateRaceWinnersList_자동차_전진하기_전_테스트() {
        String[] carNames = {"test", "car", "name"};
        List<RacingCar> racingCars = RacingCarList.generateRacingCarList(carNames);

        String winnersList = Referee.generateRaceWinnersList(racingCars);
        assertThat(winnersList).isEqualTo("test, car, name");
    }

    @Test
    void generateRaceWinnersList_자동차_한대만_전진_후_테스트() {
        String[] carNames = {"test", "car", "name"};
        List<RacingCar> racingCars = RacingCarList.generateRacingCarList(carNames);

        for (int i = 0; i < 100; i++) {
            racingCars.get(0).moveForward();
        }

        String winnersList = Referee.generateRaceWinnersList(racingCars);
        assertThat(winnersList).isEqualTo("test");
    }

}
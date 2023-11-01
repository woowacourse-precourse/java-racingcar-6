package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarServiceTest {

    @Test
    void findAllRacingCar() {
        RacingCarService racingCarService = new RacingCarService();
        RacingCar racingCar1 = racingCarService.saveRacingCar("carName1");
        RacingCar racingCar2 = racingCarService.saveRacingCar("carName2");
        RacingCar racingCar3 = racingCarService.saveRacingCar("carName3");

        List<RacingCar> racingCarList = racingCarService.findAll();
        assertThat(racingCarList).contains(racingCar1, racingCar2, racingCar3);
    }

    @Test
    void getWinners_동점() {
        RacingCarService racingCarService = new RacingCarService();

        List<RacingCar> racingCarList = new ArrayList<>();
        RacingCar racingCar1 = new RacingCar("carName1", "---", 3);
        RacingCar racingCar2 = new RacingCar("carName2", "---", 3);
        RacingCar racingCar3 = new RacingCar("carName3", "---", 3);
        racingCarList.add(racingCar1);
        racingCarList.add(racingCar2);
        racingCarList.add(racingCar3);

        List<String> winner = racingCarService.getWinner(racingCarList);
        assertThat(winner).contains(racingCar1.getCarName(), racingCar2.getCarName(), racingCar3.getCarName());
    }

    @Test
    void getWinners_우승자1명() {
        RacingCarService racingCarService = new RacingCarService();

        List<RacingCar> racingCarList = new ArrayList<>();
        RacingCar racingCar1 = new RacingCar("carName1", "---", 3);
        RacingCar racingCar2 = new RacingCar("carName2", "--", 2);
        RacingCar racingCar3 = new RacingCar("carName3", "-", 1);
        racingCarList.add(racingCar1);
        racingCarList.add(racingCar2);
        racingCarList.add(racingCar3);

        List<String> winner = racingCarService.getWinner(racingCarList);
        assertThat(winner).contains(racingCar1.getCarName());
    }

    @Test
    void getWinners_우승자2명() {
        RacingCarService racingCarService = new RacingCarService();

        List<RacingCar> racingCarList = new ArrayList<>();
        RacingCar racingCar1 = new RacingCar("carName1", "---", 3);
        RacingCar racingCar2 = new RacingCar("carName2", "---", 3);
        RacingCar racingCar3 = new RacingCar("carName3", "-", 1);
        racingCarList.add(racingCar1);
        racingCarList.add(racingCar2);
        racingCarList.add(racingCar3);

        List<String> winner = racingCarService.getWinner(racingCarList);
        assertThat(winner).contains(racingCar1.getCarName(), racingCar2.getCarName());
    }

}
package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnerTest {

    @Test
    void 중복_우승자_확인_테스트() {
        String name1 = "juni";
        String name2 = "huni";
        RacingCar racingCar1 = new RacingCar(name1, 4);
        RacingCar racingCar2 = new RacingCar(name2, 4);

        List<RacingCar> racingCars = new ArrayList<>();
        racingCars.add(racingCar1);
        racingCars.add(racingCar2);

        Winner winner = new Winner(racingCars);

        assertThat(winner.getWinnerRacingCar()).contains(name1, name2);

    }

    @Test
    void 단독_우승자_확인_테스트() {
        String name1 = "juni";
        String name2 = "huni";

        RacingCar racingCar1 = new RacingCar(name1, 4);
        RacingCar racingCar2 = new RacingCar(name2, 3);

        List<RacingCar> racingCars = new ArrayList<>();

        racingCars.add(racingCar1);
        racingCars.add(racingCar2);

        Winner winner = new Winner(racingCars);

        assertThat(winner.getWinnerRacingCar()).isEqualTo(name1);

    }

    @Test
    void 우승자_이동_거리_확인_테스트() {
        String name1 = "juni";
        String name2 = "huni";
        String name3 = "jun";

        RacingCar racingCar1 = new RacingCar(name1, 4);
        RacingCar racingCar2 = new RacingCar(name2, 2);
        RacingCar racingCar3 = new RacingCar(name3, 6);

        List<RacingCar> racingCars = new ArrayList<>();

        racingCars.add(racingCar1);
        racingCars.add(racingCar2);
        racingCars.add(racingCar3);

        Winner winner = new Winner();

        assertThat(winner.getWinnerValue(racingCars)).isEqualTo(racingCar3.getMove());

    }
}
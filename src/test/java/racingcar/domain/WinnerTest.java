package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


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

        assertThat(winner.getWinners()).hasSize(2).contains(name1, name2);
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

        assertThat(winner.getWinners()).hasSize(1).contains(name1).doesNotContain(name2);
    }
}
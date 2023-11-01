package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

    RacingCar racingCar1 = new RacingCar(new Name("a"), new Location(0));
    RacingCar racingCar2 = new RacingCar(new Name("b"), new Location(1));
    RacingCar racingCar3 = new RacingCar(new Name("c"), new Location(2));

    @Test
    void 우승자_찾기() {
        List<RacingCar> racingCarList = Arrays.asList(racingCar1, racingCar2, racingCar3);
        RacingCars racingCars = new RacingCars(racingCarList);

        RacingCars winners = racingCars.findWinners();
        List<RacingCar> winnersList = winners.racingCarList();

        assertThat(winnersList).contains(racingCar3);
        assertThat(winnersList).doesNotContain(racingCar1, racingCar2);
    }
}
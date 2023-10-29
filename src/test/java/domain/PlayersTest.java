package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    void findWinnersTest() {
        List<RacingCar> racingCars = new ArrayList<>(Arrays.asList(
                new RacingCar("Tesla"),
                new RacingCar("Ford")
        ));

        RacingCar tesla = racingCars.get(0);
        RacingCar ford = racingCars.get(0);

        tesla.moveForward();
        tesla.moveForward();
        ford.moveForward();

        Players players = new Players(racingCars);
        List<String> winners = players.findWinners();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0)).isEqualTo("Tesla");
    }

}
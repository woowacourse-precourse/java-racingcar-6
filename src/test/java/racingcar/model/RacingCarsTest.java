package racingcar.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars(
                Arrays.asList(
                        new Car("pobi", 1),
                        new Car("woni", 2),
                        new Car("jun", 3)
                )
        );
    }

    @Test
    void RacingCars_move_4보다_작으면_변화없음() {
        racingCars.checkEachCarWithNumber(3);

        Assertions.assertThat(racingCars.getRacingCars()).containsExactly(
                new Car("pobi", 1),
                new Car("woni", 2),
                new Car("jun", 3)
        );
    }

    @Test
    void RacingCars_move_4이상이면_전진한다() {
        racingCars.checkEachCarWithNumber(4);

        Assertions.assertThat(racingCars.getRacingCars()).containsExactly(
                new Car("pobi", 2),
                new Car("woni", 3),
                new Car("jun", 4)
        );
    }

    @Test
    void 우승자_한명인_경우() {
        List<Car> singleWinner = racingCars.findWinner();

        Assertions.assertThat(singleWinner.size()).isEqualTo(1);
        Assertions.assertThat(singleWinner).containsExactly(new Car("jun", 3));
    }

    @Test
    void 우승자_두_명_이상인_경우() {
        List<Car> getRacingCars = this.racingCars.getRacingCars();
        getRacingCars.add(new Car("king", 3));

        RacingCars addedRacingCars = new RacingCars(getRacingCars);
        List<Car> multipleWinners = addedRacingCars.findWinner();

        Assertions.assertThat(multipleWinners.size()).isEqualTo(2);
        Assertions.assertThat(multipleWinners).containsExactly(
                new Car("jun", 3),
                new Car("king", 3)
        );
    }
}

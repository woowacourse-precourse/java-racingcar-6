package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Movement;

public class CarsTest {

    @Test
    void 단독_우승() {
        Car winner = new Car("우승자");
        winner.move(Movement.FORWARD);
        winner.move(Movement.FORWARD);
        winner.move(Movement.FORWARD);

        Car notWinner = new Car("우승자아님");
        notWinner.move(Movement.FORWARD);

        Cars cars = new Cars(List.of(winner, notWinner));
        List<Car> findWinnersResult = cars.findWinners();

        assertThat(findWinnersResult).containsOnly(winner);
        assertThat(findWinnersResult).doesNotContain(notWinner);
    }

    @Test
    void 공동_우승() {
        Car winnerA = new Car("우승자A");
        winnerA.move(Movement.FORWARD);
        winnerA.move(Movement.FORWARD);

        Car winnerB = new Car("우승자B");
        winnerB.move(Movement.FORWARD);
        winnerB.move(Movement.FORWARD);

        Car notWinner = new Car("우승자아님");
        notWinner.move(Movement.STOP);
        notWinner.move(Movement.FORWARD);


        Cars cars = new Cars(List.of(winnerA, winnerB, notWinner));
        List<Car> findWinnersResult = cars.findWinners();

        assertThat(findWinnersResult).containsExactlyInAnyOrder(winnerA, winnerB);
        assertThat(findWinnersResult).doesNotContain(notWinner);
    }
}

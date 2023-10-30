package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class GameTest {
    @Test
    void 우승자를_가려낸다() {
        List<Car> cars = List.of(
                new Car("park",0),
                new Car("kim",2),
                new Car("jay",3),
                new Car("ray",3)
        );
        Game game = new Game(cars);

        List<Car> winner = game.pickWinner();

        Assertions.assertThat(winner.get(0).toString()).isEqualTo("jay");
        Assertions.assertThat(winner.get(1).toString()).isEqualTo("ray");
    }
}

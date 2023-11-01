package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class GameTest {

    @Test
    void 자동차들은_움직일_수_있다() {
        Car compareCar = new Car("park");
        compareCar.moveOrStop(4);
        Game game = new Game(List.of("kim", "park"));
        game.playOnce(() -> 4);

        Assertions.assertThat(game.getCars().get(0).isSamePosition(compareCar)).isTrue();
        Assertions.assertThat(game.getCars().get(1).isSamePosition(compareCar)).isTrue();
    }

    @Test
    void 자동차들은_여러번_움직일_수_있다() {
        Car compareCar = new Car("park");

        for (int i = 0; i < 3; i++) {
            compareCar.moveOrStop(4);
        }

        Game game = new Game(List.of("kim","jay"));

        for (int i = 0; i < 3; i++) {
            game.playOnce(() -> 4);
        }
        Assertions.assertThat(game.getCars().get(0).isSamePosition(compareCar)).isTrue();
        Assertions.assertThat(game.getCars().get(1).isSamePosition(compareCar)).isTrue();
    }

    @Test
    void 우승자를_가려낸다() {
        Game game = new Game(List.of("kim","park","jay"));
        game.getCars().get(0).moveOrStop(1);
        game.getCars().get(1).moveOrStop(5);
        game.getCars().get(2).moveOrStop(5);

        List<Car> winner = game.pickWinner();

        Assertions.assertThat(winner.get(0).getName()).isEqualTo("park");
        Assertions.assertThat(winner.get(1).getName()).isEqualTo("jay");
    }

    @Test
    void 자동차_이름이_중복되면_예외를_던진다() {
        assertThrows(IllegalArgumentException.class, () -> new Game(List.of("kim","kim")));
    }
}

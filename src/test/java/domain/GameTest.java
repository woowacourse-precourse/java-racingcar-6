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
        List<Car> cars = List.of(
                new Car("kim",0),
                new Car("ray",0)
        );
        Car compareCar = new Car("park",1);
        Game game = new Game(cars);
        game.playOnce(() -> 4);

        Assertions.assertThat(compareCar.isSamePosition(cars.get(0))).isTrue();
        Assertions.assertThat(compareCar.isSamePosition(cars.get(1))).isTrue();
    }

    @Test
    void 자동차들은_여러번_움직일_수_있다() {
        List<Car> cars = List.of(
                new Car("kim",0),
                new Car("ray",0)
        );
        Car compareCar = new Car("park",3);
        Game game = new Game(cars);
        for (int i = 0; i < 3; i++) {
            game.playOnce(() -> 4);
        }
        Assertions.assertThat(compareCar.isSamePosition(cars.get(0))).isTrue();
        Assertions.assertThat(compareCar.isSamePosition(cars.get(1))).isTrue();
    }

    @Test
    void 우승자를_가려낸다() {
        List<Car> cars = List.of(
                new Car("park",0),
                new Car("kim",2)
        );
        Game game = new Game(cars);
        List<Car> winner = game.pickWinner();

        Assertions.assertThat(winner.get(0).toString()).isEqualTo("kim");
    }
    @Test
    void 우승자는_여러명일수_있다() {
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

    @Test
    void 자동차_이름이_중복되면_예외를_던진다() {
        List<Car> cars = List.of(
                new Car("kim",0),
                new Car("kim",0)
        );
        assertThrows(IllegalArgumentException.class, () -> new Game(cars));
    }
}

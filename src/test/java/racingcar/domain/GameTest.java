package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        game = null;
    }

    @Test
    void 모든_자동차가_전진_확인() {
        carList = Arrays.asList(
                new Car("pobi", new TestNumberGenerator(7)),
                new Car("woni", new TestNumberGenerator(8)),
                new Car("jun", new TestNumberGenerator(9))
        );
        game = new Game(carList);
        game.playOneRound();
        assertThat(game.getCars()).allMatch(car -> car.getMoveNum() == 1);
    }

    @Test
    void 모든_자동차가_멈춤_확인() {
        carList = Arrays.asList(
                new Car("pobi", new TestNumberGenerator(1)),
                new Car("woni", new TestNumberGenerator(2)),
                new Car("jun", new TestNumberGenerator(3))
        );
        game = new Game(carList);
        game.playOneRound();
        assertThat(game.getCars()).allMatch(car -> car.getMoveNum() == 0);
    }

    @Test
    void 일부_전진_멈춤_확인() {
        carList = Arrays.asList(
                new Car("pobi", new TestNumberGenerator(1)),
                new Car("woni", new TestNumberGenerator(7)),
                new Car("jun", new TestNumberGenerator(9))
        );
        game = new Game(carList);
        game.playOneRound();
        assertThat(carList.get(0).getMoveNum()).isEqualTo(0);
        assertThat(carList.get(1).getMoveNum()).isEqualTo(1);
        assertThat(carList.get(2).getMoveNum()).isEqualTo(1);
    }
}

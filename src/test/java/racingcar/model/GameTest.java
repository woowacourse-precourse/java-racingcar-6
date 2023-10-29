package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import racingcar.model.Car;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class GameTest extends NsTest {

    List<Car> cars;
    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("a"));
        cars.add(new Car("b"));
        cars.add(new Car("c"));
    }

    @Test
    void 게임_내_자동차_수_확인() {
        Game game = new Game(3, cars);
        assertEquals(game.getCars().size(), 3);
    }

    @Test
    void 게임_내_자동차_이름_확인() {
        Game game = new Game(3, cars);
        assertEquals(game.getCars().get(0).getName(), "a");
        assertEquals(game.getCars().get(1).getName(), "b");
        assertEquals(game.getCars().get(2).getName(), "c");
    }

    @Test
    void 게임_횟수_증가() {
        Game game = new Game(3, cars);
        assertEquals(game.checkGamesExhausted(), false);
        for (int i = 0; i < 3; i ++) {
            game.increaseGameOrder();
        }
        assertEquals(game.checkGamesExhausted(), true);
    }

    @Override
    protected void runMain() {
    }
}

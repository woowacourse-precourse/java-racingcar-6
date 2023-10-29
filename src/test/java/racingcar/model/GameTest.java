package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.repository.CarRepository;

public class GameTest extends NsTest {

    CarRepository carRepository = new CarRepository();


    @Test
    void 게임_내_자동차_수_확인() {
        Game game = new Game(3, List<Car> cars);
        assertEquals(game.getCars().size(), 3);
    }

    @Test
    void 게임_내_자동차_이름_확인() {
        Game game = new Game(3, List<Car> cars);
        assertEquals(game.getCars().get(0).getName(), "a");
        assertEquals(game.getCars().get(1).getName(), "b");
        assertEquals(game.getCars().get(2).getName(), "c");
    }

    @Test
    void 게임_횟수_증가() {
        Game game = new Game(3, List<Car> cars);
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

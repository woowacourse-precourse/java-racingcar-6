package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameTest {

    Car car;
    Game game;

    @BeforeEach
    void setUp() {
        car = new Car();
        game = new Game();
    }


    @Test
    void 자동차_이름_분리_테스트() {

        String input = "pobi,jun,king";
        String[] inputs = input.split(",");
        String[] carNames = game.splitCarName(input);

        for (int i = 0; i < carNames.length; i++) {
            Assertions.assertTrue(carNames[i].length() <= 5);
        }
        Assertions.assertTrue(carNames.length == inputs.length);

    }


}

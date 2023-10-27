package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.UI;
import racingcar.domain.Validator;

public class Application {
    public static void main(String[] args) {

        Validator validator = new Validator();
        UI ui = new UI(validator);
        RacingGame racingGame = new RacingGame(ui);
        racingGame.startGame();
        racingGame.runGame();
    }
}

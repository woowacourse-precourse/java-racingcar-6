package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.UI;
import racingcar.domain.Validator;

public class Application {
    public static void main(String[] args) {

        RacingGame racingGame = new RacingGame(new UI(), new Validator());
        racingGame.startGame();
        racingGame.runGame();
    }
}

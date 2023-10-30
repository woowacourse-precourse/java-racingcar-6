package racingcar;

import racingcar.controller.Game;
import racingcar.controller.RacingGame;

public class Application {
    public static void main(String[] args) {
        Game racingGame = new RacingGame();
        racingGame.run();
    }
}

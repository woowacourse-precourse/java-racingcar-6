package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.game.RacingGame;
import racingcar.domain.generator.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new RacingGame(new RandomNumberGenerator()));
        gameController.run();
    }
}

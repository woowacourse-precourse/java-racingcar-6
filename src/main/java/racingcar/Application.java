package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.RacingGame;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();
        RacingGame racingGame = new RacingGame();
        RacingGameController racingGameController = new RacingGameController(outputManager, inputManager, racingGame);

        GameManager gameManager = new GameManager(racingGameController);
        gameManager.run();
    }
}

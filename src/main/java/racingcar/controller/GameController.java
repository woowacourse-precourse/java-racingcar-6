package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
    private final GameView gameView;

    public GameController() {
        this.gameView = new GameView();
    }

    public void gameStart() {
        String carNames = gameView.inputCarName();
        String count = gameView.inputTryCount();
        Game game = new Game(carNames, count);
        StringBuilder gameLog = game.run();
        gameView.printGameLog(gameLog);
    }
}

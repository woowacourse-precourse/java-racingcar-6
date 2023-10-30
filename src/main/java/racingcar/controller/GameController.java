package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameModel;
import racingcar.view.GameView;

public class GameController {
    private GameView gameView;
    private GameModel gameModel;

    public void gameStart() {
        this.gameView = new GameView();
        String[] carsName = gameView.inputCarsName();
        int numberGames = gameView.inputNumberGames();
        this.gameModel = new GameModel();
        gameModel.initGame(carsName, numberGames);
        gameView.printResult(gameModel.progressGame());
    }
}

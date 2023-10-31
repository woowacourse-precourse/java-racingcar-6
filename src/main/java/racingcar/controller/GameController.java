package racingcar.controller;

import racingcar.model.GameModel;
import racingcar.view.GameView;

public class GameController {
    private GameView gameView;
    private GameModel gameModel;

    public GameController() {
        this.gameView = new GameView();
        this.gameModel = new GameModel();
    }

    public void gameStart() {
        String[] carsName = gameView.inputCarsName();
        int numberGames = gameView.inputNumberGames();
        gameModel.initGame(carsName, numberGames);
        for (int i = 0; i < numberGames; i++) {
            gameView.printResult(gameModel.progressGame());
        }
        gameView.printWinner(gameModel.getWinnerCars());
    }
}

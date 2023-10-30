package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameModel;
import racingcar.view.GameView;

public class GameController {
    private GameView gameView;
    private GameModel gameModel;

    public void gameStart() {
        this.gameView = new GameView();
        this.gameModel = new GameModel();
        String[] carsName = gameView.inputCarsName();
        int numberGames = gameView.inputNumberGames();
        gameModel.initGame(carsName, numberGames);
        for (int i = 0; i < numberGames; i++) {
            gameView.printResult(gameModel.progressGame());
        }
//        gameView.printWinner(gameModel.getWinner());
    }
}

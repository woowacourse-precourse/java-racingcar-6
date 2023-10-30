package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.GameView;

public class GameController {
    private final GameView gameView;
    private Cars cars;
    private int moveCount;

    public GameController(GameView gameView) {
        this.gameView = gameView;
        this.cars = new Cars();
    }

    public void startGame() {
        getInfoFromUser();
        playRound(moveCount);
        endGame();
    }

    private void getInfoFromUser() {
 
    }

    private void playRound(int count) {

    }

    private void endGame() {

    }

}

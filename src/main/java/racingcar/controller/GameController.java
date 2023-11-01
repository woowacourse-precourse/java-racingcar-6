package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private Cars racingCars;
    private int gameCount;

    public GameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        initializeGame();
        startGame();
        endGame();
    }

    private void initializeGame() {
        outputView.displayCarName();
        racingCars = new Cars(inputView.readCarName());
        outputView.displayGameCount();
        gameCount = inputView.readCount();
    }

    private void startGame() {
        outputView.displayStart();
        while (gameCount != 0) {
            gameCount--;
            racingCars.moveCars();
            outputView.displayMovement(racingCars.getCars());
        }
    }

    private void endGame() {
        Winners winners = new Winners(racingCars.getCars());
        outputView.displayWinner(winners.getWinners());
    }
}
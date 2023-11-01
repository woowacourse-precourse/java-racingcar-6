package racingcar.controller;

import racingcar.domain.GameManager;
import racingcar.domain.TryCount;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private GameManager gameManager;
    private int tryCount;

    public void gameStart() {
        gameSetInput();
        playRacing();
        showWinnerCars();
    }

    private void gameSetInput() {
        List<String> carNames = InputView.inputCarNames();
        TryCount tryCount = InputView.inputTryCount();
    }

    private void playRacing() {
        for (int i=0; i<tryCount; i++) {
            gameManager.moveCar();
            OutputView.showCarNameAndPosition(gameManager.getCars());
        }
    }

    private void showWinnerCars() {
        Winner winner = gameManager.findWinners();
        OutputView.finalWinnerMessage(winner);
    }
}
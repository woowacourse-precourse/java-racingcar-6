package racingcar.controller;

import racingcar.service.GameService;
import racingcar.domain.TryCount;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private GameService gameService;
    private int tryCount;

    public void gameStart() {
        gameSetInput();
        playRacing();
        showWinnerCars();
    }

    private void gameSetInput() {
        List<String> carNames = InputView.inputCarNames();
        GameService.createCar(carNames);
        TryCount tryCount = InputView.inputTryCount();
    }

    private void playRacing() {
        for (int i=0; i<tryCount; i++) {
            gameService.moveCar();
            OutputView.showCarNameAndPosition(gameService.getCars());
        }
    }

    private void showWinnerCars() {
        Winner winner = gameService.findWinners();
        OutputView.finalWinnerMessage(winner);
    }
}
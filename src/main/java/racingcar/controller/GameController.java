package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.TryCount;
import racingcar.domain.Winner;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private List<Car> cars;
    private TryCount tryCount;
    private final GameService gameService;

    public GameController() {
        GameService gameService = new GameService();
        this.gameService = gameService;
    }

    public void gameStart() {
        gameSetInput();

        for (int i = 0; i < tryCount.getTryCount(); i++) {
            playRacing();
        }

        showWinnerCars();
    }

    private void gameSetInput() {
        List<String> carNames = InputView.inputCarNames();
        this.cars = GameService.createCar(carNames);
        this.tryCount = InputView.inputTryCount();
    }

    private void playRacing() {
        gameService.moveCar(cars);
        OutputView.showCarNameAndPosition(cars);
    }

    private void showWinnerCars() {
        Winner winner = gameService.findWinners(cars);
        OutputView.finalWinnerMessage(winner);
    }
}
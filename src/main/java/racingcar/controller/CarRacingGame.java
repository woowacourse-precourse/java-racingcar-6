package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRacingGame {
    private List<Car> cars;
    private int attemptTime;
    private GameService gameService;

    public CarRacingGame() {
        this.gameService = new GameService();
    }

    public void gameStart() {
        String inputCarNames = InputView.inputCarNames();
        this.cars = gameService.createCars(inputCarNames);

        String attemptNumber = InputView.inputAttemptNumber();
        gameService.validateAttemptNumber(attemptNumber);
        this.attemptTime = Integer.parseInt(attemptNumber);

        OutputView.printResultPhrase();
        while (attemptTime-- > 0) {
            gameService.playOneAttempt(cars);
            OutputView.printRacingGameStatus(cars);
        }

        List<Car> winners = gameService.getWinners(cars);
        OutputView.printWinner(winners);
    }
}

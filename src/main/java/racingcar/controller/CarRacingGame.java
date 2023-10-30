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

        this.attemptTime = Integer.parseInt(InputView.inputAttemptionNumber());

        OutputView.printResultPhrase();
        while (attemptTime-- > 0) {
            gameService.playOneAttempt(cars);
            OutputView.printRacingGameStatus(cars);
        }
    }
}

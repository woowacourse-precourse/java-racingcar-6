package racingcar.domain.controller;

import racingcar.domain.model.Car;
import racingcar.domain.service.GameService;
import racingcar.domain.view.InputView;
import racingcar.domain.view.OutputView;
import racingcar.global.util.Validator;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final Validator validator;

    public MainController(InputView inputView, OutputView outputView, GameService gameService, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
        this.validator = validator;
    }

    public void startGame() {
        outputView.printCarsName();
        String carsName = inputView.readInputData();
        validator.validateCarsName(carsName);
        Car car = Car.of(carsName);
        outputView.printNumberOfAttempts();
        String numberOfAttempts = inputView.readInputData();
        validator.validateNumberOfAttempts(numberOfAttempts);
        int count = Integer.parseInt(numberOfAttempts);
        outputView.printExecutionResult();
        while (count > 0) {
            gameService.handleCar(car);
            outputView.printExecutionResults(car);
            count--;
        }
        gameService.calculateWinnerCar(car);
        outputView.printResults(car);
    }
}

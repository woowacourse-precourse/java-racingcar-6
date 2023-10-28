package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarGameService;
import racingcar.view.OutputView;
import racingcar.view.InputView;

public class CarGameController {

    private final CarGameService carGameService;
    private final InputView inputView;
    private final OutputView outputView;

    public CarGameController() {
        this.carGameService = new CarGameService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Cars cars = receiveCars();
        int attempt = receiveAttempt();

        executeGame(cars, attempt);
        showWinner(cars);
    }

    private void showWinner(Cars cars) {
        String result = carGameService.receiveWinnerNames(cars);
        outputView.printFinalWinner(result);
    }

    private void executeGame(Cars cars, int attempt) {
        outputView.printGameResult();

        for (int iteration = 0; iteration < attempt; iteration++) {
            carGameService.applyMovingForward(cars);
            outputView.printRank(cars);
        }
    }

    private int receiveAttempt() {
        outputView.printAskAttempt();
        return inputView.readAttempt();
    }

    private Cars receiveCars() {
        outputView.printStartGame();
        String input = inputView.readCarNames();
        return carGameService.convertToCars(input);
    }
}

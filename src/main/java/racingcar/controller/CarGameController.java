package racingcar.controller;

import static racingcar.utils.Converter.convertToCars;

import racingcar.domain.Cars;
import racingcar.service.CarGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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

    private void showWinner(final Cars cars) {
        String result = carGameService.receiveWinnerNames(cars);
        outputView.printFinalWinner(result);
    }

    private void executeGame(final Cars cars, final int attempt) {
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
        return convertToCars(input);
    }
}

package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarGameService;
import racingcar.service.MessageService;
import racingcar.view.InputView;

public class CarGameController {

    private final CarGameService carGameService;
    private final MessageService messageService;
    private final InputView inputView;

    public CarGameController() {
        this.carGameService = new CarGameService();
        this.messageService = new MessageService();
        this.inputView = new InputView();
    }

    public void start() {
        Cars cars = receiveCars();
        int attempt = receiveAttempt();

        executeGame(cars, attempt);
        showWinner(cars);
    }

    private void showWinner(Cars cars) {
        String result = carGameService.receiveWinnerNames(cars);
        messageService.printFinalWinner(result);
    }

    private void executeGame(Cars cars, int attempt) {
        messageService.printGameResult();

        for (int iteration = 0; iteration < attempt; iteration++) {
            carGameService.repeatForward(cars);
            messageService.printRank(cars);
        }
    }

    private int receiveAttempt() {
        messageService.printAskAttempt();
        return inputView.readAttempt();
    }

    private Cars receiveCars() {
        messageService.printStartGame();
        String inputCars = inputView.readCarNames();
        return carGameService.convertToList(inputCars);
    }
}

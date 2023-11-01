package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.input.Input;
import racingcar.view.output.Output;

public class GameController {
    private final Input inputView = new Input();
    private final Output outputView = new Output();

    public void playGame() {
        Cars cars = makeCars();
        Integer tryNumber = inputTryNumber();
        simulateResults(cars, tryNumber);
    }

    private Cars makeCars() {
        outputView.printInputCarName();
        String[] carNames = inputView.inputCarNames();
        return Cars.makeCarsByNames(carNames);
    }

    private Integer inputTryNumber() {
        outputView.printInputTryNumber();
        return inputView.inputTryNumber();
    }

    private void simulateResults(Cars cars, Integer tryNumber) {
        outputView.printBlankLine();
        for (int round = 0; round < tryNumber; round++) {
            cars.tryCars();
            outputView.printRoundResult(cars.toString());
        }
    }
}
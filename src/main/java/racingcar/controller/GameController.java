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
        printFinalWinner(cars);
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
        outputView.printExecutionResult();
        for (int round = 0; round < tryNumber; round++) {
            cars.tryCars();
            outputView.printResult(cars.toString());
        }
    }

    private void printFinalWinner(Cars cars) {
        outputView.printWinnerResult(cars.findWinner());
    }
}
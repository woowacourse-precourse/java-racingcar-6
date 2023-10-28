package racingcar.controller;

import static racingcar.message.MessageConstants.LINE_BREAK;
import static racingcar.message.MessageConstants.ZERO;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameMachine {
    private final InputView inputView;
    private final OutputView outputView;

    public GameMachine() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        Cars cars = getCars();
        int tryCount = getTryCount();

        runRaceAndPrintResult(cars, tryCount);
    }

    public Cars getCars() {
        try {
            return inputView.inputCarName();
        } catch (IllegalStateException e) {
            return getCars();
        }
    }

    public int getTryCount() {
        try {
            return inputView.inputTryCount();
        } catch (IllegalStateException e) {
            return getTryCount();
        }
    }

    public void runRaceAndPrintResult(Cars cars, int tryCount) {
        outputView.runResultMessage();

        for (int i = ZERO; i < tryCount; i++) {
            cars.move();
            System.out.println(cars.statusMessage() + LINE_BREAK);
        }

        outputView.winnerCarsMessage(cars);
    }
}

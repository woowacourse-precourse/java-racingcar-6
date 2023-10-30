package racingcar.controller;

import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.OutView.printCarsMovingResult;
import static racingcar.view.OutView.printExecutionStart;
import static racingcar.view.OutView.printWinners;

import java.util.List;
import racingcar.model.Cars;

public class GameController {

    private Cars cars;

    public void play() {
        final int turns = prepare();
        process(turns);
        declareWinner();
    }

    private int prepare() {
        cars = Cars.from(inputCarNames());
        return inputAttemptCount();
    }

    private void process(final int turns) {
        printExecutionStart();
        for (int i = 0; i < turns; i++) {
            cars.processTurn();
            printCarsMovingResult(cars.getCarList());
        }
    }

    private void declareWinner() {
        final List<String> winners = cars.judge();
        printWinners(winners);
    }

}

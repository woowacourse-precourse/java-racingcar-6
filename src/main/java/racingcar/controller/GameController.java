package racingcar.controller;

import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.InputView.inputTurns;
import static racingcar.view.OutView.printCarsMovingResult;
import static racingcar.view.OutView.printExecutionStart;
import static racingcar.view.OutView.printWinners;

import java.util.List;
import racingcar.model.Cars;

public class GameController {

    private Cars cars;

    private int turns;

    public void play() {
        prepare();
        process();
        declareWinner();
    }

    private void prepare() {
        cars = Cars.from(inputCarNames());
        turns = inputTurns();
    }

    private void process() {
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

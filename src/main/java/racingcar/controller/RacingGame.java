package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;
    private Long tryCount;

    public void start() {
        cars = new Cars(InputView.readRacingCarName());
        tryCount = InputView.readTryCount();

        OutputView.printResultMessage();
        printResult();

        List<String> winners = cars.findWinner();
        OutputView.printWinners(winners);
    }

    private void printResult() {
        for (int i = 0; i < tryCount; i++) {
            cars.tryToMoveCars();
            OutputView.printResult(cars);
        }
    }


}
package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;
    private TryCount tryCount;

    public void start() {
        cars = new Cars(InputView.readRacingCarName());
        tryCount = new TryCount(InputView.readTryCount());

        OutputView.printResultMessage();
        printResult();

        List<String> winners = cars.findWinner();
        OutputView.printWinners(winners);
    }

    private void printResult() {
        for (int i = 0; i < tryCount.tryCount(); i++) {
            cars.tryToMoveCars();
            OutputView.printResult(cars);
        }
    }


}
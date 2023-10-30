package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;
    private TryCount tryCount;

    public void start() {
        cars = createCars(InputView.readRacingCarName());
        tryCount = new TryCount(InputView.readTryCount());

        OutputView.printResultMessage();
        printResult();

        List<String> winners = cars.findWinner();
        OutputView.printWinners(winners);
    }

    private Cars createCars(List<String> racingCarNames) {
        return new Cars(
                racingCarNames.stream()
                        .map(name -> new Car(name, new RandomNumberGenerator()))
                        .collect(Collectors.toList())
        );
    }

    private void printResult() {
        for (int i = 0; i < tryCount.tryCount(); i++) {
            cars.tryToMoveCars();
            OutputView.printResult(cars);
        }
    }


}
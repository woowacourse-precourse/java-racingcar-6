package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.model.Winners;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;
    private TryCount tryCount;

    public void start() {
        cars = readCarNames();
        tryCount = readTryCount();

        OutputView.printResultMessage();
        printResult();

        Winners winners = findWinners();
        OutputView.printWinners(winners);
    }

    private Cars readCarNames() {
        List<String> racingCarNames = InputView.readRacingCarName();
        return createCars(racingCarNames);
    }

    private Cars createCars(List<String> racingCarNames) {
        return new Cars(
                racingCarNames.stream()
                        .map(name -> new Car(name, new RandomNumberGenerator()))
                        .collect(Collectors.toList())
        );
    }

    private TryCount readTryCount() {
        return new TryCount(InputView.readTryCount());
    }

    private void printResult() {
        for (int i = 0; i < tryCount.tryCount(); i++) {
            cars.moveCars();
            OutputView.printResult(cars);
        }
    }

    private Winners findWinners() {
        return new Winners(cars.findWinners());
    }


}
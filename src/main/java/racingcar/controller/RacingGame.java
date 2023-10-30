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
        cars = createCars(InputView.readRacingCarName());
        tryCount = new TryCount(InputView.readTryCount());

        OutputView.printResultMessage();
        printResult();

        Winners winners = new Winners(findWinners());
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

    private List<String> findWinners() {
        return cars.findWinners();
    }


}
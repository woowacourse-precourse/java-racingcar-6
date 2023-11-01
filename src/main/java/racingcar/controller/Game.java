package racingcar.controller;

import java.util.List;
import racingcar.model.AttemptCount;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        String inputNames = InputView.inputNames();
        Cars cars = Cars.of(inputNames, ",");

        String inputAttemptCount = InputView.inputAttemptCount();
        AttemptCount attemptCount = AttemptCount.from(inputAttemptCount);

        OutputView.printRaceStart();
        while (attemptCount.attemptIfPossible()) {
            cars.race();
            List<Car> carList = cars.copyList();
            OutputView.printCars(carList);
        }

        List<String> winners = cars.findWinners();
        OutputView.printWinners(winners);
        InputView.close();
    }
}

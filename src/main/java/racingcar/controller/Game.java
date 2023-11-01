package racingcar.controller;

import java.util.List;
import racingcar.model.AttemptCount;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.CarsFactory;
import racingcar.model.ForwardStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    private final ForwardStrategy forwardStrategy;

    public Game(ForwardStrategy forwardStrategy) {
        this.forwardStrategy = forwardStrategy;
    }

    public void start() {
        String inputNames = InputView.inputNames();
        Cars cars = CarsFactory.createCars(inputNames);

        String inputAttemptCount = InputView.inputAttemptCount();
        AttemptCount attemptCount = AttemptCount.from(inputAttemptCount);

        OutputView.printRaceStart();
        while (attemptCount.attemptIfPossible()) {
            cars.race(forwardStrategy);
            List<Car> carList = cars.copyList();
            OutputView.printCars(carList);
        }

        List<String> winners = cars.findWinners();
        OutputView.printWinners(winners);
        InputView.close();
    }
}

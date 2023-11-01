package racingcar.controller;

import static racingcar.view.InputView.close;
import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputNames;
import static racingcar.view.OutputView.printCars;
import static racingcar.view.OutputView.printRaceStart;
import static racingcar.view.OutputView.printWinners;

import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.model.CarsFactory;
import racingcar.model.ForwardStrategy;

public class Game {
    private final ForwardStrategy forwardStrategy;

    public Game(ForwardStrategy forwardStrategy) {
        this.forwardStrategy = forwardStrategy;
    }

    public void start() {
        Cars cars = CarsFactory.createCars(inputNames());
        AttemptCount attemptCount = AttemptCount.from(inputAttemptCount());
        race(cars, attemptCount);
        printWinners(cars.findWinners());
        close();
    }

    private void race(Cars cars, AttemptCount attemptCount) {
        printRaceStart();
        while (attemptCount.attemptIfPossible()) {
            cars.race(forwardStrategy);
            printCars(cars.copyList());
        }
    }
}

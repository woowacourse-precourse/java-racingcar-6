package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingGame {
    private static final int END_COUNT = 0;

    private Cars cars;
    private int attemptCount;

    public RacingGame() {
        this.attemptCount = 0;
    }

    public void run() {
        initRacingGame();
        startPrintResultMessage();

        while (!isEnd()) {
            cars.progressAllCars();
            printAllProgress();
            attemptCount -= 1;
        }

        OutputView.printWinners(getWinners());
    }

    public void initRacingGame() {
        String[] carNames = getCarNames();

        cars = new Cars(carNames);

        attemptCount = getAttemptCount();
    }

    public boolean isEnd() {
        return attemptCount == END_COUNT;
    }

    public void printAllProgress() {
        for (Car car : cars.getCars()) {
            printProgress(car.getName(), car.getPosition());
        }
        printLine();
    }

    public List<String> getWinners() {
        return cars.getWinners().stream()
                .map(w -> w.getName())
                .collect(Collectors.toList());
    }

}

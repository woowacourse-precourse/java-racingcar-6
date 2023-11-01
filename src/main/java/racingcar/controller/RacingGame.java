package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameAttemptCount;
import racingcar.dto.CarDto;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class RacingGame {
    private Cars cars;
    private GameAttemptCount attemptCount;

    public void run() {
        initRacingGame();
        startPrintResultMessage();

        while (!attemptCount.isEnd()) {
            progress();
        }

        OutputView.printWinners(getWinnerNames());
    }

    public void initRacingGame() {
        String[] carNames = getCarNames();

        cars = new Cars(carNames);

        attemptCount = new GameAttemptCount(getAttemptCount());
    }

    public void progress() {
        cars.progressAllCars();
        printAllProgress();
        attemptCount.reduceAttemptCount();
    }

    public void printAllProgress() {
        for (Car car : cars.getCars()) {
            printProgress(CarDto.from(car));
        }
        printLine();
    }

    public List<String> getWinnerNames() {
        return cars.getWinners().stream()
                .map(w -> w.getName())
                .collect(Collectors.toList());
    }

}

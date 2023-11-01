package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private Cars cars;

    public void run() {
        OutputView.printCarNamesInputMessage();
        List<String> carNames = InputView.getCarNames();
        List<Car> carList = carNames.stream()
                .map(String::strip)
                .map(Car::new)
                .collect(Collectors.toList());

        OutputView.printAttemptsInputMessage();
        cars = new Cars(carList);

        int tryCount = InputView.getAttemptCount();
        for (int i = 0; i < tryCount; i++) {
            cars.attemptToMoveAll();
            OutputView.printRoundResult(cars.getRoundInfo());
        }

        List<String> winners = cars.getWinners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        OutputView.printWinners(winners);
    }
}

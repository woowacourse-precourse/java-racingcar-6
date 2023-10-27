package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final Cars cars = new Cars();

    public void setUp() {
        List<String> carNames = getCarNames();
        initializeCars(carNames);
        play(getAttemptCount());
    }

    private void play(int attemptCount) {
        OutputView.displayGameResultMessage();
        IntStream.range(0, attemptCount).forEach(attempt -> {
            cars.moveAll();
            OutputView.displayGameResult(cars.toString());
        });
        OutputView.displayWinners(getWinners());
    }

    private String getWinners() {
        List<String> winners = cars.getWinners();
        return String.join(", ", winners);
    }

    private List<String> getCarNames() {
        OutputView.displayCarNames();
        String names = InputView.input();
        return parseNames(names);
    }

    private int getAttemptCount() {
        OutputView.displayAttemptCount();
        String input = InputView.input();
        return Integer.parseInt(input);
    }

    private void initializeCars(List<String> carNames) {
        Validator.validateNames(carNames);
        for (String carName : carNames) {
            cars.add(carName);
        }
    }

    private List<String> parseNames(String names) {
        return Arrays.asList(names.split(","));
    }
}

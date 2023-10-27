package racingcar.controller;

import java.util.Arrays;
import java.util.List;
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
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            cars.moveAll();
            OutputView.displayGameResult(cars.toString());
        }
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
        for (String carName : carNames) {
            cars.add(carName);
        }
    }

    private List<String> parseNames(String names) {
        return Arrays.asList(names.split(","));
    }
}

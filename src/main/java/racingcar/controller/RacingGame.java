package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void setUp() {
        List<String> carNames = getCarNames();
        int attemptCount = getAttemptCount();
        Cars cars = initializeCars(carNames);
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

    private Cars initializeCars(List<String> carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.add(carName);
        }
        return cars;
    }

    private List<String> parseNames(String names) {
        return new ArrayList<>(Arrays.asList(names.split(",")));
    }
}

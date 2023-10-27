package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void play() {
        OutputView.displayCarNames();
        String names = InputView.input();

        OutputView.displayAttemptCount();
        int attemptCount = Integer.parseInt(InputView.input());
        List<String> carNames = parseNames(names);
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.add(carName);
        }
        System.out.println(cars);
    }

    private List<String> parseNames(String names) {
        return new ArrayList<>(Arrays.asList(names.split(",")));
    }
}

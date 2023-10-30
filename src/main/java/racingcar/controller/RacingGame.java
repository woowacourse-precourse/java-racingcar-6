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
        play(getTryCount());
    }

    private void play(int tryCount) {
        OutputView.displayGameResultMessage();
        IntStream.range(0, tryCount).forEach(play -> {
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
        String CarNames = InputView.input();
        return parseCarNames(CarNames);
    }

    private int getTryCount() {
        OutputView.displayTryCount();
        String input = InputView.input();
        Validator.validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void initializeCars(List<String> carNames) {
        Validator.validateCarNames(carNames);
        for (String carName : carNames) {
            cars.add(carName);
        }
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }
}

package racingcar.controller;

import static racingcar.model.Cars.createCars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void setUp() {
        List<String> carNames = getCarNames();
        Cars cars = createCars(carNames);
        play(cars, getTryCount());
    }

    private void play(Cars cars, int tryCount) {
        OutputView.displayGameResultMessage();
        IntStream.range(0, tryCount).forEach(play -> {
            cars.moveAll();
            OutputView.displayGameResult(cars.toString());
        });
        OutputView.displayWinners(getWinners(cars));
    }

    private List<String> getCarNames() {
        String carNames = InputView.getCarNames();
        return parseCarNames(carNames);
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

    private int getTryCount() {
        String tryCount = InputView.getTryCount();
        Validator.validateTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    private String getWinners(Cars cars) {
        List<String> winners = cars.getWinners();
        return String.join(", ", winners);
    }
}

package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public final class GameController {
    public static void start() {
        List<Car> cars = InputView.getCarNames();
        int numberOfAttempts = InputView.getNumberOfAttempts();

        Racing racing = new Racing(cars, numberOfAttempts);
        List<String> winners = racing.startRace();

        OutputView.displayWinners(winners);
    }
}

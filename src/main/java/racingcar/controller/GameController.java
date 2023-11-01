package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;
public final class GameController {
    public static void start() {
        List<Car> cars = InputView.inputCarNames();
        int numberOfTurns = InputView.inputNumberOfTurns();

        Race race = new Race(cars, numberOfTurns);
        List<String> winners = race.start();

        OutputView.printRaceWinners(winners);
    }
}

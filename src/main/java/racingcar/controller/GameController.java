package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.view.OutputView;

public class GameController {

    private final int rounds;
    private final RacingCars racingCars;

    public GameController() {
        this.racingCars = InputController.getCarNames();
        this.rounds = InputController.getRoundCount();
    }

    public void start() {
        OutputView.printPlayMessage();
        IntStream.range(0, rounds).forEach(i -> {
            List<Car> carStatuses = racingCars.play();
            OutputView.printRoundResult(carStatuses);
            OutputView.printNewLine();
        });
        displayWinners();
    }

    private void displayWinners() {
        List<Car> winners = racingCars.getWinners();
        OutputView.printWinner(winners);
    }
}

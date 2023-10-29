package racingcar.controller;

import java.util.stream.IntStream;
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
            racingCars.play();
            OutputView.printNewLine();
        });
        displayWinners();
    }

    private void displayWinners() {
        racingCars.showWinners();
    }
}

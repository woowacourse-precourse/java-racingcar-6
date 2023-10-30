package racingcar.controller;

import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.OutView.printCarsMovingResult;
import static racingcar.view.OutView.printExecutionStart;
import static racingcar.view.OutView.printWinners;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarsGenerator;
import racingcar.model.Game;

public class GameController {

    private final CarsGenerator carsGenerator;

    private Game game;

    public GameController(CarsGenerator carsGenerator) {
        this.carsGenerator = carsGenerator;
    }

    public void play() {
        final int turns = prepare();
        process(turns);
        declareWinner();
    }

    private int prepare() {
        final List<Car> cars = carsGenerator.generate(inputCarNames());
        game = new Game(cars);
        return inputAttemptCount();
    }

    private void process(final int turns) {
        printExecutionStart();
        for (int i = 0; i < turns; i++) {
            final List<Car> result = game.processTurn();
            printCarsMovingResult(result);
        }
    }

    private void declareWinner() {
        final List<String> winners = game.judge();
        printWinners(winners);
    }

}

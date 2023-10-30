package racingcar.controller;

import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.OutView.printAttemptResults;
import static racingcar.view.OutView.printExecutionStart;
import static racingcar.view.OutView.printWinners;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarsGenerator;
import racingcar.model.Game;

public class GameController {

    private final CarsGenerator carsGenerator;

    private Game game;
    private int attemptCount;

    public GameController(CarsGenerator carsGenerator) {
        this.carsGenerator = carsGenerator;
    }

    public void play() {
        final List<Car> cars = carsGenerator.generate(inputCarNames());
        game = new Game(cars);
        attemptCount = inputAttemptCount();

        printExecutionStart();
        for (int i = 0; i < attemptCount; i++) {
            game.run();
            printAttemptResults(game.getCars());
        }

        final List<String> winners = game.judge();
        printWinners(winners);
    }

}

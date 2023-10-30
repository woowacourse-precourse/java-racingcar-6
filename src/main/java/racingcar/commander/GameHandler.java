package racingcar.commander;

import java.util.List;

import racingcar.communication.Communicator;
import racingcar.exception.ExceptionHandler;
import racingcar.game.GameProgress;
import racingcar.game.car.Car;
import racingcar.game.Game;

public class GameHandler {
    private final Game game;

    public GameHandler(Game game) {
        this.game = game;
    }

    public void handle() {
        try {
            setUp();
            runGame();
            finishGame();
        } catch (RuntimeException exception) {
            ExceptionHandler.handleException(exception);
        }
    }

    private void setUp() {
        List<String> carNames = Communicator.instructInputCars();
        game.setUp(carNames);
    }

    private void runGame() {
        int trials = Communicator.instructInputTrials();
        List<GameProgress> gameResult = game.playAll(trials);
        Communicator.printResult(gameResult);
    }

    private void finishGame() {
        List<Car> winners = game.getWinners();
        Communicator.printWinners(winners);
    }
}

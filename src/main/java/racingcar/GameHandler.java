package racingcar;

import java.util.List;

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
        game.saveCars(carNames);
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

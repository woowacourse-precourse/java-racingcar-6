package racingcar;

import java.util.List;

public class GameHandler {
    private final Game game;

    public GameHandler(Game game) {
        this.game = game;
    }


    public void handle() {
        try {
            List<String> carNames = Communicator.instructInputCars();
            game.saveCars(carNames);

            int trials = Communicator.instructInputTrials();
            List<GameProgress> gameResult = game.playAll(trials);

            Communicator.printResult(gameResult);

            List<Car> winners = game.getWinners();
            Communicator.printWinners(winners);
        } catch (RuntimeException exception) {
            ExceptionHandler.handleException(exception);
        }
    }
}

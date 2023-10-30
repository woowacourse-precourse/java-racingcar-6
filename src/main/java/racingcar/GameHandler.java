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

            Communicator.printResult();
            for (int i = 0; i < trials; i++) {
                GameProgress gameProgress = game.playOnce();
                Communicator.printProgress(gameProgress);
            }

            List<Car> winners = game.getWinners();
            Communicator.printWinners(winners);
        } catch (RuntimeException exception) {
            ExceptionHandler.handleException(exception);
        }
    }
}

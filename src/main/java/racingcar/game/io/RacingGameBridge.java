package racingcar.game.io;

import java.util.List;
import racingcar.game.RacingGame;

public class RacingGameBridge {
    private RacingGame racingGame;
    private RacingGameResponder racingGameResponder;

    private boolean initialized = false;

    public void initializeGame() {
        List<String> names = RacingGamePrompter.promptNames();
        Integer rounds = RacingGamePrompter.promptRounds();

        racingGame = new RacingGame(names, rounds);
        racingGameResponder = new RacingGameResponder();

        initialized = true;
    }

    public void runGame() {
        if (!initialized) {
            return;
        }
        while(!racingGame.isFinished()) {
            racingGame.tryToProceedCars();
            racingGameResponder.informGameProcess(racingGame.getGameProgress());
        }
        racingGameResponder.informGameResult(racingGame.getWinners());
    }
}

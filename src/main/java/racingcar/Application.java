package racingcar;

import static racingcar.game.GameUtils.GAME_THRESHOLD;
import static racingcar.game.GameUtils.PROGRESS_COMMAND;

import java.util.List;
import racingcar.game.Game;
import racingcar.game.Result;
import racingcar.io.GameArgumentReader;

public class Application {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        List<String> carNames = GameArgumentReader.readCarNames();
        String attemptNumber = GameArgumentReader.readAttemptNumber();

        Game game = new Game(carNames, attemptNumber, GAME_THRESHOLD, PROGRESS_COMMAND);
        Result result = game.start();
        result.print();
    }
}


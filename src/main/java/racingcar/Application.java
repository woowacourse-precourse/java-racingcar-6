package racingcar;

import static racingcar.game.GameUtils.GAME_THRESHOLD;
import static racingcar.game.GameUtils.PROGRESS_COMMAND;

import java.util.List;
import racingcar.game.Game;
import racingcar.game.Result;
import racingcar.io.ConsoleInputReader;
import racingcar.io.GameArgumentReader;

public class Application {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        GameArgumentReader gameArgumentReader = new GameArgumentReader(new ConsoleInputReader());
        List<String> carNames = gameArgumentReader.readCarNames();
        String attemptNumber = gameArgumentReader.readAttemptNumber();

        Game game = new Game(carNames, attemptNumber, GAME_THRESHOLD, PROGRESS_COMMAND);
        Result result = game.start();
        result.print();
    }
}


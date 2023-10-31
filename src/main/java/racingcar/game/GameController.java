package racingcar.game;

import static racingcar.utils.GameUtils.GAME_THRESHOLD;
import static racingcar.utils.GameUtils.INITIAL_PROGRESS;
import static racingcar.utils.GameUtils.PROGRESS_COMMAND;

import java.util.List;
import racingcar.io.GameArgumentReader;
import racingcar.io.InputReader;

public class GameController {

    private final GameArgumentReader gameArgumentReader;
    private GameArgument gameArgument;

    public GameController(InputReader inputReader) {
        gameArgumentReader = new GameArgumentReader(inputReader);
    }

    public void setup() {
        List<String> carNames = gameArgumentReader.readCarNames();
        String attemptNumber = gameArgumentReader.readAttemptNumber();
        gameArgument = new GameArgument(carNames, attemptNumber);
    }

    public void start() {
        RacingGame racingGame = createRacingGame();
        RacingGameResult result = racingGame.process();
        result.print();
    }

    private RacingGame createRacingGame() {
        List<Car> cars = gameArgument.getCarNames().stream().map(name -> Car.of(name, INITIAL_PROGRESS)).toList();
        int attemptNumber = Integer.parseInt(gameArgument.getAttemptInput());
        return RacingGame.of(cars, attemptNumber, GAME_THRESHOLD, PROGRESS_COMMAND,
                new RandomNumberGenerator());
    }

    public GameArgument getGameArgument() {
        return gameArgument;
    }
}

package racingcar.game;

import static racingcar.utils.GameUtils.GAME_THRESHOLD;
import static racingcar.utils.GameUtils.PROGRESS_COMMAND;

import java.util.List;
import racingcar.car.Car;
import racingcar.io.ConsoleInputReader;
import racingcar.io.GameArgumentReader;
import racingcar.result.RacingGameResult;

public class GameController {

    private final GameArgumentReader gameArgumentReader;
    private List<String> carNames;
    private String attemptInput;

    public GameController() {
        gameArgumentReader = new GameArgumentReader(new ConsoleInputReader());
    }

    public void setup() {
        carNames = gameArgumentReader.readCarNames();
        attemptInput = gameArgumentReader.readAttemptNumber();
    }

    public void start() {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        int attemptNumber = Integer.parseInt(attemptInput);
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        RacingGame racingGame = RacingGame.of(cars, attemptNumber, GAME_THRESHOLD, PROGRESS_COMMAND, numberGenerator);
        RacingGameResult racingGameResult = racingGame.process();
        racingGameResult.print();
    }
}

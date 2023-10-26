package racingcar;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.io.ConsoleProcessor;
import racingcar.model.Car;

public class RacingGame {

    private final ConsoleProcessor consoleProcessor;

    public RacingGame() {
        this.consoleProcessor = new ConsoleProcessor();
    }


    public void hostGame() {
        final String[] carNames = consoleProcessor.registerCarNames();

        Map<Car, Integer> scoreBoard = initScoreBoard(carNames);

        System.out.println(scoreBoard);

        consoleProcessor.closeConsole();
    }

    private Map<Car, Integer> initScoreBoard(final String[] carNames) {
        return Arrays.stream(carNames)
                .collect(Collectors.toMap(
                        Car::new, carName -> 0,
                        (a, b) -> b
                ));
    }
}

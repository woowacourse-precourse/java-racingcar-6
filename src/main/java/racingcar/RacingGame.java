package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.io.ConsoleProcessor;
import racingcar.model.Car;
import racingcar.model.LoopCount;

public class RacingGame {

    private static final int BOUND = 4;

    private Map<Car, Integer> scoreBoard;

    private final ConsoleProcessor consoleProcessor;

    public RacingGame() {
        this.consoleProcessor = new ConsoleProcessor();
    }


    public void hostGame() {
        final String[] carNames = consoleProcessor.getCarNames();

        scoreBoard = initScoreBoard(carNames);
        final LoopCount loopCount = LoopCount.of(consoleProcessor.getLoopCount());

        for (int round = 0; round < loopCount.getValue(); round++) {
            playRound();
        }

        consoleProcessor.closeConsole();
    }

    private void playRound() {
        scoreBoard.forEach((key, value) -> {
            int count = regulateCount(Randoms.pickNumberInRange(0, 9));
            scoreBoard.put(key, value + count);
        });
        System.out.println(scoreBoard);
    }

    private int regulateCount(final int count) {
        final int regulatedCount = count - BOUND;
        if (regulatedCount >= 0) {
            return regulatedCount;
        }
        return 0;
    }

    private Map<Car, Integer> initScoreBoard(final String[] carNames) {
        return Arrays.stream(carNames)
                .collect(Collectors.toMap(Car::new, carName -> 0,
                        (a, b) -> b));
    }
}

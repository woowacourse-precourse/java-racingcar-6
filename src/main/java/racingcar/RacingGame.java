package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.io.ConsoleProcessor;
import racingcar.model.Car;
import racingcar.model.LoopCount;

public class RacingGame {

    private static final int BOUND = 4 - 1;

    private Map<Car, Integer> scoreBoard;

    private final ConsoleProcessor consoleProcessor;

    public RacingGame() {
        this.consoleProcessor = new ConsoleProcessor();
    }


    protected void hostGame() {
        final String[] carNames = consoleProcessor.getCarNames();

        scoreBoard = initScoreBoard(carNames);
        final LoopCount loopCount = LoopCount.of(consoleProcessor.getLoopCount());

        consoleProcessor.printRacingGameResult();

        for (int round = 0; round < loopCount.getValue(); round++) {
            playRound();
        }

        List<String> winners = getWinners(scoreBoard);
        consoleProcessor.printWinners(winners);

        consoleProcessor.closeConsole();
    }

    private void playRound() {
        scoreBoard.forEach((key, value) -> {
            int count = regulateCount(Randoms.pickNumberInRange(0, 9));
            consoleProcessor.printRoundScore(key.getName(), count);
            scoreBoard.put(key, value + count);
        });
        consoleProcessor.printNewLine();
    }

    private List<String> getWinners(final Map<Car, Integer> scoreBoard) {
        final int maxCount = scoreBoard.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        return scoreBoard.entrySet().stream()
                .filter(entry -> entry.getValue() >= maxCount)
                .map(entry -> entry.getKey().getName())
                .toList();
    }

    private int regulateCount(final int count) {
        final int regulatedCount = count - BOUND;
        return Math.max(regulatedCount, 0) + BOUND;
    }

    private Map<Car, Integer> initScoreBoard(final String[] carNames) {
        return Arrays.stream(carNames)
                .collect(Collectors.toMap(Car::new, carName -> 0,
                        (a, b) -> b));
    }
}

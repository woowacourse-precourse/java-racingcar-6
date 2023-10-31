package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.operateProcess.operate;
import racingcar.impormation.RacingCar;
import racingcar.impormation.racing;

public class RacingGame {

    private Map<RacingCar, Integer> scoreNum;

    private final operate printoutput;

    public RacingGame() {
        this.printoutput = new operate();
    }


    public void startplay() {
        final String[] carNames = printoutput.getCarNames();

        scoreNum = initScore(carNames);
        final racing loopCount = racing.of(printoutput.getoperate());

        printoutput.printRacingresult();

        for (int round = 0; round < loopCount.getValue(); round++) {
            Round();
        }

        List<String> winners = victory(scoreNum);
        printoutput.printVictory(winners);

        printoutput.closeConsole();
    }

    private void Round() {
        scoreNum.forEach((key, value) -> {
            int count = regulate(Randoms.pickNumberInRange(0, 9));
            printoutput.printScore(key.getName(), count);
            scoreNum.put(key, value + count);
        });
        printoutput.printNewLine();
    }

    private List<String> victory(final Map<RacingCar, Integer> scoreNum) {
        final int maxCount = scoreNum.values().stream()
                .max(Integer::compareTo)
                .orElse(0);

        return scoreNum.entrySet().stream()
                .filter(entry -> entry.getValue() >= maxCount)
                .map(entry -> entry.getKey().getName())
                .toList();
    }

    private int regulate(final int count) {
        final int regulatedCount = count - 3;
        return Math.max(regulatedCount, 0);
    }

    private Map<RacingCar, Integer> initScore(final String[] carNames) {
        return Arrays.stream(carNames)
                .collect(Collectors.toMap(RacingCar::new, carName -> 0,
                        (a, b) -> b));
    }
}
package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingGame {

    private Map<RacingCar, Integer> scoreNum;

    private final UserInterface printoutput;

    public RacingGame() {
        this.printoutput = new UserInterface();
    }


    public void startplay() {
        final String[] carNames = printoutput.getCarNames();

        scoreNum = initScore(carNames);
        final Racing loopCount = Racing.of(printoutput.getOperationCount());

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

    private int regulate(final int randomValue) {
        // 랜덤한 값이 4 이상인 경우에만 1을 반환하여 전진을 나타냅니다.
        // 그렇지 않은 경우에는 0을 반환하여 제자리에 머무르게 합니다.
        return randomValue >= 4 ? 1 : 0;
    }

    private Map<RacingCar, Integer> initScore(final String[] carNames) {
        return Arrays.stream(carNames)
                .collect(Collectors.toMap(RacingCar::new, carName -> 0,
                        (a, b) -> b));
    }
}

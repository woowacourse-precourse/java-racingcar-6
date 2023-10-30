package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class RacingGame {
    private static final int RANDOM_MOVE_LIMIT = 4;
    private final String[] carNames;
    private final int tryCount;
    private final int[] distance;

    public RacingGame(String[] carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
        this.distance = new int[carNames.length];
        Arrays.fill(distance, 0);
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            proceedRound();
            OutputView.printRoundResult(carNames, distance);
        }
    }

    private void proceedRound() {
        for (int i = 0; i < distance.length; ++i) {
            if (canMove()) {
                distance[i] += 1;
            }
        }
    }

    private boolean canMove() {
        int number = RandomUtils.getRandomNumber();
        if (number >= RANDOM_MOVE_LIMIT) {
            return true;
        }
        return false;
    }

    public void findWinners() {
        int maxDistance = -1;
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                winners.clear();
                winners.add(carNames[i]);
            } else if (distance[i] == maxDistance) {
                winners.add(carNames[i]);
            }
        }
        OutputView.printWinner(winners);
    }
}


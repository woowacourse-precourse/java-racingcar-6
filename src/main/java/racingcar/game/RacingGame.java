package racingcar.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class RacingGame {
    private static final int RANDOM_MOVE_LIMIT = 4;
    private static final int INITIAL_DISTANCE = 0;
    private static final int MOVE_DISTANCE = 1;
    private final String[] carNames;
    private final int tryCount;
    private final int[] distance;

    public RacingGame(String[] carNames, int tryCount) {
        this.carNames = carNames;
        this.tryCount = tryCount;
        this.distance = new int[carNames.length];
        Arrays.fill(distance, INITIAL_DISTANCE);
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            proceedRound();
            OutputView.printRoundResult(carNames, distance);
        }
    }

    private void proceedRound() {
        for (int i = 0; i < distance.length; ++i) {
            int number = RandomUtils.getRandomNumber();
            if (canMove(number)) {
                move(i);
            }
        }
    }

    private void move(int i) {
        distance[i] += MOVE_DISTANCE;
    }

    private boolean canMove(int number) {
        if (number >= RANDOM_MOVE_LIMIT) {
            return true;
        }
        return false;
    }

    public void printWinners() {
        List<String> winners = getWinners();
        OutputView.printWinner(winners);
    }

    private List<String> getWinners() {
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
        return winners;
    }
}


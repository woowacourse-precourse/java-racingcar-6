package racingcar.controller;

import racingcar.model.Racer;
import java.util.ArrayList;
import java.util.List;

public class WinnerDecider {
    public static String getWinner(List<Racer> racers) {
        int maxMoveCount = findMaxMoveCount(racers);
        List<String> winners = findWinners(racers, maxMoveCount);
        return String.join(", ", winners);
    }

    private static int findMaxMoveCount(List<Racer> racers) {
        int maxMoveCount = 0;
        for (Racer racer : racers) {
            int moveCount = racer.getMoveCount();
            maxMoveCount = Math.max(maxMoveCount, moveCount);
        }
        return maxMoveCount;
    }

    private static List<String> findWinners(List<Racer> racers, int maxMoveCount) {
        List<String> winners = new ArrayList<>();
        for (Racer racer : racers) {
            if (racer.getMoveCount() == maxMoveCount) {
                winners.add(racer.getName());
            }
        }
        return winners;
    }
}
package racingcar.game.model;

import java.util.ArrayList;
import java.util.List;

public class WinnerData {
    private final String DELIMITER = ", ";
    private int winnerMoveCount;
    private List<String> winnerNames;

    public WinnerData(int moveCount) {
        winnerMoveCount = moveCount;
        winnerNames = new ArrayList<>();
    }

    protected int compareMoveCount(int moveCount) {
        return Integer.compare(winnerMoveCount, moveCount);
    }

    protected void addWinnerName(String name) {
        winnerNames.add(name);
    }

    public String concatWinnerNames() {
        return String.join(DELIMITER, winnerNames);
    }
}

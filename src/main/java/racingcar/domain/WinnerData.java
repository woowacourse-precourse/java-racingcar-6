package racingcar.domain;

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

    public String concatWinnerNames() {
        return String.join(DELIMITER, winnerNames);
    }
    
    protected int compareMoveCount(int moveCount) {
        return Integer.compare(winnerMoveCount, moveCount);
    }

    protected void addWinnerName(String name) {
        winnerNames.add(name);
    }
}

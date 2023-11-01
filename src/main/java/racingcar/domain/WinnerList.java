package racingcar.domain;

import java.util.List;

public class WinnerList {
    private final List<String> winnerNames;

    public WinnerList(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
package racingcar.model;

import java.util.List;

public class WinnerList {
    private final List<String> winnerList;

    public WinnerList(List<String> winnerName) {
        this.winnerList = winnerName;
    }

    public List<String> getWinnerList() {
        return winnerList;
    }
}

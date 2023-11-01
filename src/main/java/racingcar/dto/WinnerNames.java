package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class WinnerNames {
    private final List<String> winnerNames;

    public WinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> getWinnerNames() {
        return Collections.unmodifiableList(winnerNames);
    }
}

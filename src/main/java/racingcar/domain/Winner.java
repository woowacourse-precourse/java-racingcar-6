package racingcar.domain;

import java.util.List;

public class Winner {
    private final List<String> winnerCarNames;

    public Winner(List<String> winnerCarNames) {
        this.winnerCarNames = winnerCarNames;
    }

    public String getWinnerCarNames() {
        return String.join(", ",winnerCarNames);
    }
}
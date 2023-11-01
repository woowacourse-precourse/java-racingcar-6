package racingcar.dto.response;

import java.util.List;
import racingcar.model.Racing;

public class WinnerNames {

    private final List<String> winnerNames;

    private WinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public static WinnerNames of(Racing racing) {
        return new WinnerNames(racing.getWinningCarNames());
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}

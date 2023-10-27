package racingcar.domain.game;

import java.util.List;

public record WinnersResult(
        List<String> winnerNames
) {
    public String getAt(final int index) {
        return winnerNames.get(index);
    }
}

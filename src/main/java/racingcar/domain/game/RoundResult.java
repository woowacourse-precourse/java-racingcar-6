package racingcar.domain.game;

import java.util.List;

public record RoundResult(
        List<MoveResult> moveResults
) {
}

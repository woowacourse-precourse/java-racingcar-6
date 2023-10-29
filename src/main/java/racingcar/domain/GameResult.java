package racingcar.domain;

import java.util.List;

public record GameResult(
        List<RoundHistory> roundHistory,

        List<Name> winners
) {
}

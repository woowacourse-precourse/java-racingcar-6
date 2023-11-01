package racingcar;

import java.util.List;

public record RacingResult(List<String> winnerNames,
                           List<RacingRoundResult> racingRoundResults) {

}

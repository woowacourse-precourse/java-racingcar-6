package racingcar.racing;

import java.util.List;

public record RacingResult(List<String> winnerNames,
                           List<RacingRoundResult> racingRoundResults) {

}

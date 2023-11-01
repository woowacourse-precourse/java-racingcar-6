package racingcar.domain;

import java.util.List;
import racingcar.view.ResultView;

public record RacingGameConfig(List<String> carNames, int totalRounds, ResultView resultView) {
}

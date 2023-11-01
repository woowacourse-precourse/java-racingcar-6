package racingcar.domain;

import java.util.List;
import racingcar.view.ResultView;

public class RacingGameConfig {
    private final List<String> carNames;
    private final int totalRounds;
    private final ResultView resultView;

    public RacingGameConfig(final List<String> carNames, final int totalRounds, final ResultView resultView) {
        this.carNames = carNames;
        this.totalRounds = totalRounds;
        this.resultView = resultView;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public ResultView getResultView() {
        return resultView;
    }
}

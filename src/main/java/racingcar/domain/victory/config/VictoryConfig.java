package racingcar.domain.victory.config;

import racingcar.domain.victory.VictoryManager;
import racingcar.domain.victory.VictoryView;

public class VictoryConfig {
    private VictoryManager cashedVictoryManager;
    private VictoryView cashedVictoryView;

    public VictoryView victoryView() {
        if (cashedVictoryView == null) {
            cashedVictoryView = new VictoryView();
        }
        return cashedVictoryView;
    }

    public VictoryManager victoryManager() {
        if (cashedVictoryManager == null) {
            cashedVictoryManager = new VictoryManager(victoryView());
        }
        return cashedVictoryManager;
    }
}

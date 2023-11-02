package racingcar.config;

import racingcar.domain.Circuit;
import racingcar.controller.RacingGame;

public class RacingGameConfig {

    public RacingGame initRacingGame() {
        Circuit circuit = new Circuit();
        return new RacingGame(circuit);
    }
}

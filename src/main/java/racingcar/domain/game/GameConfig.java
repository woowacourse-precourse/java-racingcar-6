package racingcar.domain.game;

import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

public class GameConfig {
    public NumberGenerator numberGenerator() {
        return RandomNumberGenerator.getInstance();
    }
}

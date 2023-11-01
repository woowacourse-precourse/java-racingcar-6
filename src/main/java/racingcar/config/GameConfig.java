package racingcar.config;

import racingcar.domain.MovingStrategy;

public class GameConfig {

    private MovingStrategy movingStrategy;

    public GameConfig(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public MovingStrategy getMovingStrategy() {
        return movingStrategy;
    }
}

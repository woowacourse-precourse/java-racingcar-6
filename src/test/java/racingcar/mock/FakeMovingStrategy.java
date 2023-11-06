package racingcar.mock;

import racingcar.model.movingstrategy.RacingCarMovingStrategy;

public class FakeMovingStrategy {

    public static final RacingCarMovingStrategy ALWAYS_MOVING_STRATEGY = () -> true;
    public static final RacingCarMovingStrategy NEVER_MOVING_STRATEGY = () -> false;
}

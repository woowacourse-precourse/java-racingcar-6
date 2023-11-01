package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MINIMAL_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int MOVING_THRESHOLD = 4;

    private RandomMovingStrategy() {
    }

    public static RandomMovingStrategy instance() {
        return new RandomMovingStrategy();
    }

    @Override
    public boolean movable() {
        int randomNumber = Randoms.pickNumberInRange(MINIMAL_NUMBER, MAXIMUM_NUMBER);
        return randomNumber >= MOVING_THRESHOLD;
    }
}

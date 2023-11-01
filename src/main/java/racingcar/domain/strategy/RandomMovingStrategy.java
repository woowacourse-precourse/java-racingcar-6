package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int MINIMAL_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    private RandomMovingStrategy() {
    }

    public static RandomMovingStrategy instance() {
        return new RandomMovingStrategy();
    }

    @Override
    public boolean movable() {
        int randomNumber = Randoms.pickNumberInRange(MINIMAL_NUMBER, MAXIMUM_NUMBER);
        RandomMovingStrategyThreshold movingThreshold = RandomMovingStrategyThreshold.from(randomNumber);

        return movingThreshold.over();
    }
}

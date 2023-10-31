package racingcar.domain.strategy;

import racingcar.constant.rule.MovementRule;
import racingcar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMoveStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean isMovable() {
        int randomNumber = randomNumberGenerator.getNumber();
        return randomNumber >= MovementRule.FORWARD_MINIMUM_VALUE.getValue();
    }
}

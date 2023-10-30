package racingcar.domain;

import racingcar.utils.GameRules;

public class RandomMoveStrategy implements MovableStrategy {
    private RandomMoveStrategy() {
    }

    public static RandomMoveStrategy createStrategy() {
        return new RandomMoveStrategy();
    }

    @Override
    public boolean isMove() {
        int randomNumber = NumberGenerator.generateNumber();
        return randomNumber >= GameRules.GO_CONDITION.getValue();
    }
}

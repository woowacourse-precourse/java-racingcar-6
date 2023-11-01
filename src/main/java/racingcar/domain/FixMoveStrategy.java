package racingcar.domain;

import racingcar.utils.GameRules;

public class FixMoveStrategy implements MovableStrategy {
    private int inputNumber;

    private FixMoveStrategy(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    public static FixMoveStrategy from(int inputNumber) {
        return new FixMoveStrategy(inputNumber);
    }

    @Override
    public boolean isMove() {
        return inputNumber >= GameRules.GO_CONDITION.getValue();
    }
}

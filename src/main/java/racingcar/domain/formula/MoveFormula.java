package racingcar.domain.formula;

import racingcar.domain.generator.NumberGenerator;

public class MoveFormula implements Formula {

    private static final int MINIMUM_MOVING_CONDITIONS = 4;

    private final NumberGenerator numberGenerator;

    public MoveFormula(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public MoveState move() {
        if (numberGenerator.generate() >= MINIMUM_MOVING_CONDITIONS) {
            return MoveState.MOVING_FORWARD;
        }
        return MoveState.STOP;
    }
}

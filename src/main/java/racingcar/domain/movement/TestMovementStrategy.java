package racingcar.domain.movement;

import static racingcar.utils.RacingConfig.MOVE_FORWARD_VALUE;

public class TestMovementStrategy implements MovementStrategy {

    private final int fixedNumber;

    public TestMovementStrategy(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public boolean couldMove() {
        return fixedNumber >= MOVE_FORWARD_VALUE;
    }
}

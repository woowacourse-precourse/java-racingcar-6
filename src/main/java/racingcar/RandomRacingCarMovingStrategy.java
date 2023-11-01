package racingcar;

import racingcar.util.Range;
import racingcar.util.RangedRandomNumberPicker;

public class RandomRacingCarMovingStrategy implements RacingCarMovingStrategy {

    private final int movingStandard;
    private final RangedRandomNumberPicker rangedRandomNumberPicker;

    public RandomRacingCarMovingStrategy(int movingStandard, Range randomNumberRange) {
        this.movingStandard = movingStandard;
        this.rangedRandomNumberPicker = new RangedRandomNumberPicker(randomNumberRange);
    }

    @Override
    public boolean canMoveForward() {
        return rangedRandomNumberPicker.pickNumber() >= movingStandard;
    }
}

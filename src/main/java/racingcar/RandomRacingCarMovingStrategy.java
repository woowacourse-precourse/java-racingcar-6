package racingcar;

import racingcar.util.RangedRandomNumberPicker;

public class RandomRacingCarMovingStrategy implements RacingCarMovingStrategy {

    private final int movingStandard;
    private final RangedRandomNumberPicker rangedRandomNumberPicker;

    public RandomRacingCarMovingStrategy(int movingStandard, int randomRangeStart, int randomRangeEnd) {
        this.movingStandard = movingStandard;
        this.rangedRandomNumberPicker = new RangedRandomNumberPicker(randomRangeStart, randomRangeEnd);
    }

    @Override
    public boolean canMoveForward() {
        return rangedRandomNumberPicker.pickNumber() >= movingStandard;
    }
}

package racingcar.model.movingstrategy;

public class RandomRacingCarMovingStrategy implements RacingCarMovingStrategy {

    private static final int MOVING_STANDARD = 4;
    private static final int RANDOM_RANGE_START = 0;
    private static final int RANDOM_RANGE_END = 9;

    private final RangedRandomNumberPicker rangedRandomNumberPicker;

    public RandomRacingCarMovingStrategy() {
        this.rangedRandomNumberPicker = new RangedRandomNumberPicker(RANDOM_RANGE_START, RANDOM_RANGE_END);
    }

    @Override
    public boolean canMoveForward() {
        return rangedRandomNumberPicker.pickNumber() >= MOVING_STANDARD;
    }
}

package racingcar.domain.move;

import number.NumberPicker;

public final class RandomMovePicker implements MovePicker {

    private static final int MIN_GO_NUMBER = 4;

    private final NumberPicker numberPicker;

    public RandomMovePicker(final NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    @Override
    public Move pick() {
        final int number = numberPicker.pick();

        if (number < MIN_GO_NUMBER) {
            return Move.STAY;
        }
        return Move.FORWARD;
    }
}

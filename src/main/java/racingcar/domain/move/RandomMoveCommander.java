package racingcar.domain.move;

import number.NumberPicker;

public final class RandomMoveCommander implements MoveCommander {

    private static final int MIN_GO_NUMBER = 4;
    private final NumberPicker numberPicker;

    public RandomMoveCommander(final NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    @Override
    public MoveCommand nextCommand() {
        final int number = numberPicker.pick();
        if (number >= MIN_GO_NUMBER) {
            return MoveCommand.GO;
        }
        return MoveCommand.STAY;
    }
}

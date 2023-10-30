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
        if (canGo()) {
            return MoveCommand.GO;
        }
        return MoveCommand.STAY;
    }

    private boolean canGo() {
        final int number = numberPicker.pick();
        return number >= MIN_GO_NUMBER;
    }
}

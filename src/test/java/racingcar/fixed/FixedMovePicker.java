package racingcar.fixed;

import racingcar.domain.move.Move;
import racingcar.domain.move.MovePicker;

public final class FixedMovePicker implements MovePicker {

    private final Move move;

    public FixedMovePicker(final Move move) {
        this.move = move;
    }

    @Override
    public Move pick() {
        return move;
    }
}

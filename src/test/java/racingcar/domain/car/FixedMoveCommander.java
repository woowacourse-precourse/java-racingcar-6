package racingcar.domain.car;

import racingcar.domain.move.MoveCommand;
import racingcar.domain.move.MoveCommander;

public final class FixedMoveCommander implements MoveCommander {

    private final MoveCommand moveCommand;

    public FixedMoveCommander(final MoveCommand moveCommand) {
        this.moveCommand = moveCommand;
    }

    @Override
    public MoveCommand nextCommand() {
        return moveCommand;
    }
}

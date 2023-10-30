package racingcar.model;

import static racingcar.util.Constant.ZERO;

public class Position {

    private int currentSpace;

    private Position(final int currentSpace) {
        this.currentSpace = currentSpace;
    }

    public static Position createDefault() {
        return new Position(ZERO.getValue());
    }

    public void moveToNext() {
        currentSpace++;
    }

    public int getCurrentSpace() {
        return currentSpace;
    }
}

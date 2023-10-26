package racingcar.domain;

public class Position {
    private static final int INIT_POSITION = 0;
    private static final int MOVING_INTERVAL = 1;

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position init() {
        return new Position(INIT_POSITION);
    }
}

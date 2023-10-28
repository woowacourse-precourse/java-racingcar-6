package model;

public class MoveCount {

    private static final int INITIAL_MOVE_COUNT = 0;

    private final int moveCount;

    private MoveCount(final int count) {
        this.moveCount = count;
    }

    public static MoveCount initialMoveCount() {
        return new MoveCount(INITIAL_MOVE_COUNT);
    }
}

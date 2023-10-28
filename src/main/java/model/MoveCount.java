package model;

public class MoveCount {

    private static final int INITIAL_MOVE_COUNT = 0;

    private int moveCount;

    private MoveCount(final int count) {
        this.moveCount = count;
    }

    public static MoveCount initialMoveCount() {
        return new MoveCount(INITIAL_MOVE_COUNT);
    }

    public void moveForward() {
        moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }
}

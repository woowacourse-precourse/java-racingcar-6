package model;

public class MoveCount implements Comparable<MoveCount> {

    private static final int INITIAL_MOVE_COUNT = 0;

    private Integer moveCount;

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

    @Override
    public int compareTo(final MoveCount count) {
        return moveCount - count.moveCount;
    }

    @Override
    public boolean equals(final Object value) {
        if (this == value) {
            return true;
        }

        if (!(value instanceof MoveCount countValue)) {
            return false;
        }

        return moveCount.equals(countValue.moveCount);
    }

    @Override
    public int hashCode() {
        return moveCount.hashCode();
    }
}

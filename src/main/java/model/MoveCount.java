package model;

public class MoveCount {

    private static final int INITIAL_MOVE_COUNT = 0;
    private static final int EQUAL_VALUE_COMPARE_RESULT = 0;

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

    public boolean hasSameValue(final MoveCount countValue) {
        return compareTo(countValue) == EQUAL_VALUE_COMPARE_RESULT;
    }

    public int getMoveCount() {
        return moveCount;
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

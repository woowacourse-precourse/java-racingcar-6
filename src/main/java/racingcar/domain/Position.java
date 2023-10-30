package racingcar.domain;

final class Position {
    private static final int NEXT_MOVE = 1;
    private static final int INIT_NUMBER = 0;

    private final int moveCount;

    private Position(int moveCount) {
        this.moveCount = moveCount;
    }

    public static Position init() {
        return new Position(INIT_NUMBER);
    }

    public Position next() {
        return new Position(moveCount + NEXT_MOVE);
    }

    public int getMoveCount() {
        return moveCount;
    }


}

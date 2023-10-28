package racingcar;

public class MoveOpportunity {

    int moveCount;

    public MoveOpportunity(int moveCount) {
        validateMoveCount(moveCount);
        this.moveCount = moveCount;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 0이상이여야 합니다.");
        }
    }

    public boolean isZero() {
        return moveCount == 0;
    }

    public void move() {
        if (moveCount == 0) {
            throw new IllegalStateException("더 이상 이동할 수 없습니다.");
        }

        moveCount--;
    }
}

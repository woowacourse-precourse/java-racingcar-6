package racingcar;

public class MoveCount {

    int moveCount;

    public MoveCount(int moveCount) {
        validateMoveCount(moveCount);
        this.moveCount = moveCount;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 0이상이여야 합니다.");
        }
    }
}

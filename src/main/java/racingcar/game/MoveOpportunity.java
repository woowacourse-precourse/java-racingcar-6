package racingcar.game;

public class MoveOpportunity {

    private final int moveOpportunity;

    public MoveOpportunity(int moveOpportunity) {
        validateMoveCount(moveOpportunity);
        this.moveOpportunity = moveOpportunity;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 0이상이여야 합니다.");
        }
    }

    public boolean isZero() {
        return moveOpportunity == 0;
    }

    public MoveOpportunity move() {
        if (moveOpportunity == 0) {
            throw new IllegalStateException("더 이상 이동할 수 없습니다.");
        }

        return new MoveOpportunity(moveOpportunity - 1);
    }
}

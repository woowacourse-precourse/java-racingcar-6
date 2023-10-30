package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class MoveCount {
    private int moveCount;

    public MoveCount(String moveCount) throws IllegalArgumentException {
        validateMoveCount(moveCount);
        this.moveCount = Integer.parseInt(moveCount);
    }

    private void validateMoveCount(String moveCount) throws IllegalArgumentException {
        try {
            int inputNumber = Integer.parseInt(moveCount);
            if (inputNumber < 0) {
                throw new IllegalArgumentException("시도 횟수는 0 이상만 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void decreaseCount() {
        if (isRemained()) {
            moveCount--;
        }
    }

    public boolean isRemained() {
        return moveCount > 0;
    }
}

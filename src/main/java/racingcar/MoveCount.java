package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class MoveCount {
    private final int moveCount;

    public MoveCount(String moveCount) {
        validateMoveCount(moveCount);
        this.moveCount = Integer.parseInt(moveCount);
    }

    private void validateMoveCount(String moveCount) {
        try {
            int inputNumber = Integer.parseInt(moveCount);
            if (inputNumber < 0) {
                throw new IllegalArgumentException("시도 횟수는 0 이상만 가능합니다.");
            }

        } catch (NumberFormatException e) {
            Console.close();
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}

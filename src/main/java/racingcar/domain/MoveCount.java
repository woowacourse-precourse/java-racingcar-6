package racingcar.domain;

import static racingcar.exception.MoveNumberException.*;

public class MoveCount {

    private int moveCount;

    public MoveCount(String input) {
        validateFormat(input);
        int moveCount = Integer.parseInt(input);
        validateMoveNumberRange(moveCount);
        this.moveCount = moveCount;
    }

    public boolean tryMove() {
        if (moveCount > 0) {
            moveCount--;
            return true;
        }
        return false;
    }
}

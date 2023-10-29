package racingcar.domain.car;

import static racingcar.domain.car.SupportedMove.*;

public class MoveCount implements Comparable<MoveCount> {

    private static final int MOVE_VALUE = 4;

    private int moveCount;

    public void controlMovement(int controlValue) {
        if (controlValue >= MOVE_VALUE) {
            this.moveCount = MOVE.calculate(moveCount);
            return;
        }
        this.moveCount = STOP.calculate(moveCount);
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public int compareTo(MoveCount other) {
        return this.moveCount - other.moveCount;
    }

    public boolean findSameMoveCount(MoveCount other) {
        return this.moveCount == other.moveCount;
    }

}

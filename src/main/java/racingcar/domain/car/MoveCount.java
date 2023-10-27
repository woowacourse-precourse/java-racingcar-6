package racingcar.domain.car;

import static racingcar.domain.car.SupportedMove.*;

public class MoveCount {

    private static final int MOVE_VALUE = 4;
    private int moveCount;

    public MoveCount() {
        this.moveCount = 0;
    }

    public void controlMovement(int controlValue){
        if (controlValue >= MOVE_VALUE){
            this.moveCount = MOVE.calculate(moveCount);
            return;
        }
        this.moveCount = STOP.calculate(moveCount);
    }

    public int getMoveCount() {
        return moveCount;
    }
}

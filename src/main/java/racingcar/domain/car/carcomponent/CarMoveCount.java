package racingcar.domain.car.carcomponent;

public class CarMoveCount {
    private final int moveCount;

    public CarMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public CarMoveCount countMove(boolean moveOrNot) {
        if (moveOrNot) {
            return new CarMoveCount(moveCount + 1);
        }
        return this;
    }
}

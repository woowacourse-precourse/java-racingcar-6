package racingcar.domain.car.carcomponent.carmove;

public class TotalMoveCount {
    private final int totalNumberToMove;

    public TotalMoveCount(int totalNumberToMove) {
        this.totalNumberToMove = totalNumberToMove;
    }

    protected boolean isCarMovable(CarMoveCount carMoveCount) {
        return this.totalNumberToMove > carMoveCount.moveCount();
    }
}

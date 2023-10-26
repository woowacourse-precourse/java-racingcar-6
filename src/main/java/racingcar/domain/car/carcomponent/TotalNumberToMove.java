package racingcar.domain.car.carcomponent;

public class TotalNumberToMove {

    private final int totalNumberToMove;
    private CarMoveCount carMoveCount;

    public TotalNumberToMove(int totalNumberToMove) {
        this.totalNumberToMove = totalNumberToMove;
        carMoveCount = new CarMoveCount(0);
    }

    public void moveCar() {
        carMoveCount = carMoveCount.countMove(canMoveCar());
    }

    public boolean canMoveCar() {
        return this.totalNumberToMove > carMoveCount.getMoveCount();
    }
}

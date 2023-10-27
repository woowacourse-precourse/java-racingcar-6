package racingcar.domain.car.carcomponent.carmove;

public class CarMoveReader {

    private final TotalMoveCount totalCountToMove;
    private CarMoveCount carMoveCount;

    public CarMoveReader(int totalCountToMove) {
        this.totalCountToMove = new TotalMoveCount(totalCountToMove);
        carMoveCount = new CarMoveCount(0);
    }

    public void moveCar() {
        carMoveCount = carMoveCount.countMove(canMoveCar());
    }

    public boolean canMoveCar() {
        return totalCountToMove.isCarMovable(carMoveCount);
    }
}

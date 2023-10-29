package racingcar.domain.car.carcomponent.carmove;

public class CarMoveReader {
    private final TotalMoveNumber totalMoveNumber;
    private CarMoveCount carMoveCount;

    public CarMoveReader(int totalMoveNumber) {
        this.totalMoveNumber = new TotalMoveNumber(totalMoveNumber);
        carMoveCount = new CarMoveCount(0);
    }

    public void raiseMoveCount() {
        carMoveCount = carMoveCount.raiseMoveCount();
    }

    public boolean canMoveCar() {
        return totalMoveNumber.isCarMovable(carMoveCount);
    }
}

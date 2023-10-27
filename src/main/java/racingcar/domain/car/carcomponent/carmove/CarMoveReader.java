package racingcar.domain.car.carcomponent.carmove;

import static racingcar.Constant.ZERO;

public class CarMoveReader {
    private final TotalMoveNumber totalMoveNumber;
    private CarMoveCount carMoveCount;

    public CarMoveReader(int totalMoveNumber) {
        this.totalMoveNumber = new TotalMoveNumber(totalMoveNumber);
        carMoveCount = new CarMoveCount(ZERO);
    }

    public void moveCar() {
        carMoveCount = carMoveCount.raiseMoveCount();
    }

    public boolean canMoveCar() {
        return totalMoveNumber.isCarMovable(carMoveCount);
    }
}

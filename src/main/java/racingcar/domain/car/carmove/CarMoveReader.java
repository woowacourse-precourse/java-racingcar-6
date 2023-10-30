package racingcar.domain.car.carmove;

public class CarMoveReader {
    private static final String ATTEMPT_TIME_NOT_NUMBER_ERROR = "시도 횟수는 숫자를 입력해야 합니다.";

    private final TotalMoveNumber totalMoveNumber;
    private CarMoveCount carMoveCount;

    private CarMoveReader(int totalMoveNumber) {
        this.totalMoveNumber = new TotalMoveNumber(totalMoveNumber);
        carMoveCount = new CarMoveCount(0);
    }

    public static CarMoveReader makeCarMoveReader(String totalMoveNumber) {
        try {
            int times = Integer.parseInt(totalMoveNumber);
            return new CarMoveReader(times);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_TIME_NOT_NUMBER_ERROR);
        }
    }

    public void raiseMoveCount() {
        carMoveCount = carMoveCount.raiseMoveCount();
    }

    public boolean canMoveCar() {
        return totalMoveNumber.isCarMovable(carMoveCount);
    }
}

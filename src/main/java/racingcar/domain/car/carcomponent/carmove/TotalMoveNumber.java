package racingcar.domain.car.carcomponent.carmove;


import static racingcar.Constant.ZERO;

public class TotalMoveNumber {
    private static final String TOTAL_MOVE_NUMBER_MINUS_ERROR = "시도 횟수는 0 이상의 숫자 입력이 필요합니다.";

    private final int totalMoveNumber;

    public TotalMoveNumber(int totalMoveNumber) {
        validateTotalMoveNumber(totalMoveNumber);
        this.totalMoveNumber = totalMoveNumber;
    }

    protected boolean isCarMovable(CarMoveCount carMoveCount) {
        return this.totalMoveNumber > carMoveCount.moveCount();
    }

    private void validateTotalMoveNumber(int totalMoveNumber) {
        if (totalMoveNumber < ZERO) {
            throw new IllegalArgumentException(TOTAL_MOVE_NUMBER_MINUS_ERROR);
        }
    }
}

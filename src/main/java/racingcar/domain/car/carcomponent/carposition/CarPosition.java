package racingcar.domain.car.carcomponent.carposition;

public class CarPosition {
    private static final String RESULT_MESSAGE_COMPONENT = "-";
    private static final String WRONG_CAR_POSITION_MESSAGE = "자동차의 위치에 음수가 들어왔습니다.";

    private final int position;

    public CarPosition(int position) {
        validatePositionIsPositive();
        this.position = position;
    }

    public CarPositionCompareResult compare(CarPosition otherCarPosition) {
        if (this.position < otherCarPosition.position) {
            return CarPositionCompareResult.SMALL;
        }
        if (this.position > otherCarPosition.position) {
            return CarPositionCompareResult.BIG;
        }
        return CarPositionCompareResult.SAME;
    }

    public CarPosition move() {
        return new CarPosition(position + 1);
    }

    public String makePositionResultMessage() {
        return RESULT_MESSAGE_COMPONENT.repeat(position);
    }

    private void validatePositionIsPositive() {
        if (position < 0) {
            throw new IllegalArgumentException(WRONG_CAR_POSITION_MESSAGE);
        }
    }
}

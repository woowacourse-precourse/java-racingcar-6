package racingcar.domain.car.carcomponent.carposition;

import static racingcar.Constant.ONE;

import racingcar.Constant;

public class CarPosition {
    private static final String RESULT_MESSAGE_COMPONENT = "-";

    private final int position;

    public CarPosition(int position) {
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
        return new CarPosition(position + ONE);
    }

    public String makePositionResultMessage() {
        return RESULT_MESSAGE_COMPONENT.repeat(Math.max(Constant.ZERO, position));
    }
}

package racingcar.domain.car.carcomponent;

public class CarPosition {
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
        return new CarPosition(position + 1);
    }
}

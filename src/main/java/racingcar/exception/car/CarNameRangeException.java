package racingcar.exception.car;

public class CarNameRangeException extends IllegalArgumentException {
    private static final String CAR_NAME_OUT_OF_RANGE_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";

    public CarNameRangeException() {
        super(CAR_NAME_OUT_OF_RANGE_MESSAGE);
    }
}

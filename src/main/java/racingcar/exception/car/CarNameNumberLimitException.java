package racingcar.exception.car;

public class CarNameNumberLimitException extends IllegalArgumentException {
    private static final String OUT_OF_RANGE_MESSAGE = "자동차 이름은 6글자 이상일 수 없습니다.";

    public CarNameNumberLimitException() {
        super(OUT_OF_RANGE_MESSAGE);
    }
}

package racingcar.domain.car;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;
    private static final String INVALID_LENGTH_ERROR_MESSAGE = "각 자동차 이름의 길이는 1-5 사이여야 합니다.";

    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    public static CarName clone(CarName carName) {
        return new CarName(carName.value);
    }

    private void validate(String target) {
        validateLength(target);
    }

    private void validateLength(String target) {
        if (isInvalidLength(target)) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isInvalidLength(String name) {
        return name.length() > MAX_LENGTH || name.length() < MIN_LENGTH;
    }

    @Override
    public String toString() {
        return value;
    }

}
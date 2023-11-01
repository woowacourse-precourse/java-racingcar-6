package racingcar.domain;

public class CarName {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 1~5자 길이로 입력해주세요.";
    private static final String COLON = " : ";

    private final String carName;

    public CarName(String carName) {
        validateNameLength(carName);
        this.carName = carName;
    }

    private void validateNameLength(String carName) {
        if (!(carName.length() <= CAR_NAME_MAX_LENGTH && carName.length() >= CAR_NAME_MIN_LENGTH)) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String makeNameForPrintResult() {
        return carName + COLON;
    }

    public Winner registerAsWinner() {
        return new Winner(carName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CarName temp) {
            return carName.equals(temp.carName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return carName.hashCode();
    }
}

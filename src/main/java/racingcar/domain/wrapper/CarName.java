package racingcar.domain.wrapper;

public class CarName {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName create(String carName) {
        validateCarName(carName);
        return new CarName(carName);
    }

    public static void validateCarName(String carName) {
        if (carName.isBlank() || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 이하만 가능합니다.");
        }
    }

    public String getCarName() {
        return carName;
    }
}

package racingcar;

public class CarName {
    private static final int MAX_LENGTH_CAR_NAME = 5;
    private static final String ERROR_BLANK_CAR_NAME = "자동차 이름은 공백은 불가합니다.";
    private static final String ERROR_MAX_LENGTH_CAR_NAME = "자동차 이름은 5자 이하만 가능합니다.";

    private String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_CAR_NAME);
        }
        if (carName.length() > MAX_LENGTH_CAR_NAME) {
            throw new IllegalArgumentException(ERROR_MAX_LENGTH_CAR_NAME);
        }
    }

    public String getName() {
        return name;
    }
}

package racingcar.domain.wrapper;

import racingcar.domain.exception.BadCarNameException;

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
            throw new BadCarNameException("자동차 이름 길이 제한을 벗어났습니다.");
        }
    }

    public String getCarName() {
        return carName;
    }
}

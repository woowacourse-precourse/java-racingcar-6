package racingcar.domain;

import racingcar.common.util.ErrorMessage;
import racingcar.common.util.StatusEnum;

public class Car {

    private final String carName;

    private int location = 0;

    private static final int CAR_NAME_LIMIT = 5;

    public Car(String carName) {
        this.carName = validationLimitLength(carName);
    }

    private String validationLimitLength(String carName) {
        if (carName.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.VALIDATE_LIMIT_NAME
                    .getMessage());
        }
        return carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }

    public void move(StatusEnum statusEnum) {
        if (statusEnum == StatusEnum.MOVE) {
            location++;
        }
    }

    public boolean isWinner(int topLocation) {
        return this.location == topLocation;
    }
}

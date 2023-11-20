package racingcar.domain;


import static racingcar.domain.CarRule.*;
import static racingcar.message.ErrorMessage.CAR_NAME_ERROR;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.location = CAR_LOCATION_INIT.getNumber();
    }

    public void move(int number) {
        if (number >= CAR_MOVE_MINIMUM.getNumber()) {
            this.location += CAR_LOCATION_STEP.getNumber();
        }
    }

    private void validateName(String newCarName) {
        if (!(newCarName.length() <= CAR_NAME_MIN_SIZE.getNumber())) {
            throw new IllegalArgumentException(CAR_NAME_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}

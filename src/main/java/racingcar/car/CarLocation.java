package racingcar.car;

import java.util.Objects;
import racingcar.util.Validator;

public class CarLocation {
    private static final int MIN_NUMBER_FOR_MOVE = 4;
    private static final int MOVE_UNIT = 1;
    private int location;

    public CarLocation(int location) {
        validateLocation(location);
        this.location = location;
    }

    private void validateLocation(int location) {
        Validator validator = new Validator();
        validator.validateCarLocation(location);
    }

    public void increaseLocation(int randomNumber) {
        if (canIncreaseLocation(randomNumber)) {
            location = location + MOVE_UNIT;
        }
    }

    private boolean canIncreaseLocation(int randomNumber) {
        return randomNumber >= MIN_NUMBER_FOR_MOVE;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarLocation that = (CarLocation) o;
        return getLocation() == that.getLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation());
    }
}

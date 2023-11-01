package racingcar.vo;

import static racingcar.constants.Integers.MAX_CAR_NAME_LENGTH;

import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import racingcar.exception.CarNameLengthExceedException;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        checkNameLength(carName);
        this.carName = carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName otherName = (CarName) o;
        return this.carName.equals(otherName.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.carName);
    }





    private void checkNameLength(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH.show()) {
            throw new CarNameLengthExceedException();
        }
    }


    public String show() {
        return carName;
    }
}

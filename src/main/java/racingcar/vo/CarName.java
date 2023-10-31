package racingcar.vo;

import static racingcar.constants.Integers.*;

import java.util.Objects;
import racingcar.constants.Integers;
import racingcar.exception.CarNameLengthExceedException;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        checkNameFormat(carName);
        this.carName = carName;
    }

    private void checkNameFormat(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH.show()) {
            throw new CarNameLengthExceedException();
        }
    }


    public String show () {
        return carName;
    }
}

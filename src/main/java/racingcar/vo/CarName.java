package racingcar.vo;

import java.util.Objects;
import racingcar.exception.CarNameLengthExceedException;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        checkNameFormat(carName);
        this.carName = carName;
    }

    private void checkNameFormat(String name) {
        if (name.length() > 5) {
            throw new CarNameLengthExceedException();
        }
    }


    public String show () {
        return carName;
    }
}

package racingcar.domain;

import static racingcar.util.FinalNumber.INIT_LOCATION;
import static racingcar.util.FinalNumber.MAX_CAR_NAME;
import static racingcar.view.ExceptionMessage.ExceprionMessage.IS_VALID_NAME_MAX_5;

public class Car {
    public String carName;
    public int location;

    public Car(String carName) {
        validateCarLength(carName);

        this.carName = carName;
        this.location = INIT_LOCATION;
    }

    public void forward() {
        this.location++;
    }

    public void validateCarLength(String carName) {
        if ( carName.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException(IS_VALID_NAME_MAX_5);
        }
    }
}

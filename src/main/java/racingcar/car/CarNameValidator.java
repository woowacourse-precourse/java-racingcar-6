package racingcar.car;

import racingcar.Constants;
import racingcar.Util;

import java.util.ArrayList;

public class CarNameValidator {
    public final String NAMES;
    public final ArrayList<String> NAMELIST;

    public CarNameValidator(String carNames) {
        this.NAMES = carNames;
        this.NAMELIST = Util.carNamesToArrayList(carNames);
    }

    public void validate(){
        isBlank();
        isRightNameLength();
    }

    public void isBlank() {
        if (NAMELIST.stream().anyMatch(name -> name.isEmpty())) {
            throw new IllegalArgumentException(Constants.INPUT_WRONG_ERROR_MESSAGE);
        }
    }

    public void isRightNameLength() {
        if (NAMELIST.stream().anyMatch(name -> name.length() > Constants.NAME_SIZE)) {
            throw new IllegalArgumentException(Constants.CAR_NAME_SIZE_ERROR_MESSAGE);
        }
    }
}

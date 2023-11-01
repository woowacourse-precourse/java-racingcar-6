package racingcar.car;

import racingcar.Constants;
import racingcar.Utils;

import java.util.ArrayList;

public class CarNameValidator {
    public final String NAMES;
    public final ArrayList<String> NAMELIST;

    public CarNameValidator(String carNames) {
        this.NAMES = carNames;
        this.NAMELIST = Utils.carNamesToArrayList(carNames);
        validate();
    }

    public void validate(){
        isBlank();
        isString();
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

    public void isString(){
        if (!Constants.CAR_NAMES_PATTERN.matcher(NAMES).matches()) {
            throw new IllegalArgumentException(Constants.ERROR + Constants.CAR_NAME_WRONG_ERROR_MESSAGE);
        }
    }
}

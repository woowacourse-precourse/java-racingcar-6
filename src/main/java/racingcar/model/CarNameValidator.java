package racingcar.model;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;
import racingcar.util.Util;

import java.util.ArrayList;

public class CarNameValidator {
    public final String NAME;
    public final ArrayList<String> NAMES;

    public CarNameValidator(String nameString) {
        this.NAME = nameString;
        this.NAMES = Util.toArrayList(nameString);
        validate();
    }

    public void validate(){
        isRightNamesString();
        isNotDuplicate();
        isRightNameSize();
    }
    public void isRightNamesString() {
        if (!Constant.namesStringPattern.matcher(NAME).matches()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_WRONG_ERROR);
        }
    }

    public void isRightNameSize() {
        if (NAMES.stream().anyMatch(name -> name.isEmpty() || name.length() > Constant.NAME_SIZE)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_SIZE_ERROR);
        }
    }

    public void isNotDuplicate() {
        if (NAMES.size() != NAMES.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE_ERROR);
        }
    }

}

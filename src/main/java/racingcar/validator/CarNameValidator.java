package racingcar.validator;

import racingcar.constant.Constants;
import racingcar.util.Utils;

import java.util.List;

public class CarNameValidator {
    private final String carNames;
    public final List<String> carNameList;

    public CarNameValidator(String carNames) {
        this.carNames = carNames;
        this.carNameList = Utils.toList(carNames);
        validate();
    }

    public void validate() {
        isNameValid();
        isNameDuplicated();
        isNameWithinRange();
    }

    public void isNameWithinRange() {
        if (carNameList.stream().anyMatch(name -> name.length() > Constants.NAME_MIN_LENGTH || name.isEmpty())) {
            throw new IllegalArgumentException(Constants.NAME_OUT_OF_RANGE_ERROR);
        }
    }

    public void isNameValid() {
        if (carNames.matches(Constants.INVALID_CHARACTER)) {
            throw new IllegalArgumentException(Constants.NAME_INVALID_ERROR);
        }
    }

    public void isNameDuplicated() {
        if (carNameList.stream().distinct().count() != carNameList.size()) {
            throw new IllegalArgumentException(Constants.NAME_DUPLICATE_ERROR);
        }
    }
}

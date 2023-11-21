package racingcar.validation;

import static racingcar.constant.Constant.Five;
import static racingcar.constant.Constant.ZERO;
import static racingcar.constant.ValidateMessage.CAR_NAME_CAN_NOT_BE_DUPLICATE;
import static racingcar.constant.ValidateMessage.CAR_NAME_INPUT_ERROR;
import static racingcar.constant.ValidateMessage.CAR_NAME_MUST_BE_LOWER_THAN_FIVE;
import static racingcar.constant.ValidateMessage.CAR_NAME_MUST_NOT_BE_NULL_OR_EMPTY;

import java.util.ArrayList;
import java.util.List;

public class CarNameValidation {

    public void isNullOrEmpty(String carName) {
        if (carName == null || carName.length() == ZERO.number) {
            CAR_NAME_MUST_NOT_BE_NULL_OR_EMPTY.throwException();
        }
    }

    public void checkCommaError(String carName) {
        if (carName.contains(",,")) {
            CAR_NAME_INPUT_ERROR.throwException();
        }
        if (carName.charAt(carName.length() - 1) == ',' || carName.charAt(0) == ',') {
            CAR_NAME_INPUT_ERROR.throwException();
        }
    }

    public List<String> checkDuplicate(String carName) {
        String[] carNames = carName.split(",");
        List<String> names = new ArrayList<>();

        for (String name : carNames) {
            String character = name.trim();
            if (names.contains(character)) {
                CAR_NAME_CAN_NOT_BE_DUPLICATE.throwException();
            }
            names.add(character);
        }

        return names;
    }

    public List<String> checkCarNameLength(List<String> carNames) {
        List<String> names = new ArrayList<>();

        for (String name : carNames) {
            if (name.length() > Five.number) {
                CAR_NAME_MUST_BE_LOWER_THAN_FIVE.throwException();
            }
            names.add(name);
        }

        return names;
    }
}

package racingcar.util;

import racingcar.constant.CarNamesExceptionMessage;
import racingcar.constant.GameConfig;
import racingcar.constant.Separator;

public class CarNamesInputValidator {
    private CarNamesInputValidator() {
    }

    public static void validate(String input) {
        inputNotEmptyValidate(input);
        for (String carName : input.split(Separator.INPUT_CAR_SEPARATOR.getSeparator(), -1)) {
            carNameValidate(carName);
        }
    }

    private static void inputNotEmptyValidate(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(CarNamesExceptionMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void carNameValidate(String carName) {
        carNameLengthValidate(carName);
    }

    private static void carNameLengthValidate(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(CarNamesExceptionMessage.EMPTY_CAR_NAME.getMessage());
        }

        if (carName.length() > GameConfig.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(CarNamesExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }
}

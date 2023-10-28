package racingcar.util;

import racingcar.constant.CarNamesInputExceptionMessage;

public class CarNamesInputValidator {
    private CarNamesInputValidator() {
    }

    public static void validate(String input) {
        inputNotEmptyValidate(input);
        for (String carName : input.split(",", -1)) {
            carNameValidate(carName);
        }
    }

    private static void inputNotEmptyValidate(String input) {
        if(input.trim().isEmpty()) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.EMPTY_INPUT.getMessage());
        }
    }
    private static void carNameValidate(String carName) {
        carNameLengthValidate(carName);
    }

    private static void carNameLengthValidate(String carName) {
        if(carName.trim().isEmpty()) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.EMPTY_CAR_NAME.getMessage());
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException(CarNamesInputExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }
}

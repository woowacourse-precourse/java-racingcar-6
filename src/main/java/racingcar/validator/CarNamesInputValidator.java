package racingcar.validator;

import racingcar.constant.GameConstant;
import racingcar.constant.InputConstant;
import racingcar.constant.message.CarNamesInputErrorMessage;

public class CarNamesInputValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
        containsDelimiter(userInput);
        isEndsWithDelimiter(userInput);
        isEachCarNameLengthInAppropriateRange(userInput);
    }

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
        }
    }

    private void containsDelimiter(String userInput) {
        if (!userInput.contains(InputConstant.INPUT_CAR_NAMES_DELIMITER)) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_DOES_NOT_CONTAIN_DELIMITER);
        }
    }

    private void isEndsWithDelimiter(String userInput) {
        if (userInput.endsWith(InputConstant.INPUT_CAR_NAMES_DELIMITER)) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
        }
    }

    private void isEachCarNameLengthInAppropriateRange(String userInput) {
        String[] carNames = userInput.split(InputConstant.INPUT_CAR_NAMES_DELIMITER);
        isEachCarNameLengthUnderLimit(carNames);
        isEachCarNameLengthIsNotEmpty(carNames);
    }

    private void isEachCarNameLengthUnderLimit(String[] carNames) {
        for (String carName : carNames) {
            throwExceptionIfLengthExceedsLimit(carName);
        }
    }

    private void throwExceptionIfLengthExceedsLimit(String carName) {
        if (carName.length() > GameConstant.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_LENGTH_EXCEEDS_LIMIT);
        }
    }

    private void isEachCarNameLengthIsNotEmpty(String[] carNames) {
        for (String carName : carNames) {
            isNotEmpty(carName);
        }
    }
}
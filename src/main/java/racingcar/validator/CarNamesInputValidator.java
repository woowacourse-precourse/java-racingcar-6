package racingcar.validator;

import racingcar.constant.GameConstant;
import racingcar.constant.InputConstant;
import racingcar.constant.message.CarNamesInputErrorMessage;

public class CarNamesInputValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
        containsDelimiter(userInput);
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

    private void isEachCarNameLengthInAppropriateRange(String userInput) {
        String[] carNames = userInput.split(InputConstant.INPUT_CAR_NAMES_DELIMITER);
        String trimmedCarName;
        for (String carName : carNames) {
            trimmedCarName = carName.trim();
            if (trimmedCarName.length() > GameConstant.CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_LENGTH_EXCEEDS_LIMIT);
            }
            if (trimmedCarName.isEmpty()) {
                throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_IS_EMPTY);
            }
        }
    }
}
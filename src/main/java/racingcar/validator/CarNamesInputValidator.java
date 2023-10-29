package racingcar.validator;

import racingcar.constant.Constant;
import racingcar.constant.ErrorMessage;

public class CarNamesInputValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
        containsDelimiter(userInput);
        isEachCarNameLengthInAppropriateRange(userInput);
    }

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CAR_NAME_EMPTY);
        }
    }

    private void containsDelimiter(String userInput) {
        if (!userInput.contains(Constant.INPUT_CAR_NAMES_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CAR_NAMES_NOT_CONTAIN_DELIMITER);
        }
    }

    private void isEachCarNameLengthInAppropriateRange(String userInput) {
        String[] carNames = userInput.split(Constant.INPUT_CAR_NAMES_DELIMITER);
        String trimmedCarName;
        for (String carName : carNames) {
            trimmedCarName = carName.trim();
            if (trimmedCarName.length() > Constant.CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_CAR_NAME_LENGTH_EXCEEDS_LIMIT);
            }
            if (trimmedCarName.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_CAR_NAME_EMPTY);
            }
        }
    }

}

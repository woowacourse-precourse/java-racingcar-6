package racingcar.validator;

import java.util.Arrays;
import racingcar.constant.GameConstant;
import racingcar.constant.InputConstant;
import racingcar.constant.message.CarNamesInputErrorMessage;

public class CarNamesInputValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
        containsDelimiter(userInput);
        isEndsWithDelimiter(userInput);
        isEachCarNameLengthInAppropriateRange(userInput);
        isDuplicated(userInput);
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

    private void isDuplicated(String userInput) {
        String[] carNames = userInput.split(InputConstant.INPUT_CAR_NAMES_DELIMITER);
        trimCarNames(carNames);
        throwExceptionIfCarNameIsDuplicated(carNames);
    }

    private void trimCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private void throwExceptionIfCarNameIsDuplicated(String[] carNames) {
        long distinctCarNamesCount = Arrays.stream(carNames).distinct().count();
        if (distinctCarNamesCount < carNames.length) {
            throw new IllegalArgumentException(CarNamesInputErrorMessage.INPUT_CAR_NAMES_DUPLICATED);
        }
    }

}
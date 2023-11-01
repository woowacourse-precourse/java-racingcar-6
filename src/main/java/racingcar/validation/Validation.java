package racingcar.validation;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.constant.ErrorMessage;

public class Validation {
    private static final String DELIMITER = ",";
    private static final String NUMERIC_PATTERN = "^[0-9]*$";

    public void validateCarNames(String carNames) {
        validateNull(carNames, ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());
        validateBlank(carNames, ErrorMessage.CAR_NAME_INPUT_EXCEPTION.getMessage());
        validateLengthAndDuplication(carNames.split(DELIMITER));
    }

    public void validateMovementTime(String movementTime) {
        validateNull(movementTime, ErrorMessage.MOVEMENT_TIME_INPUT_EXCEPTION.getMessage());
        validateBlank(movementTime, ErrorMessage.MOVEMENT_TIME_INPUT_EXCEPTION.getMessage());
        validateNumericValue(movementTime);
    }

    private void validateNull(String data, String errorMessage) {
        if (data == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateBlank(String data, String errorMessage) {
        if (data.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateLengthAndDuplication(String[] carNames) {
        Set<String> distinctCarNames = new HashSet<>();
        for(String carName : carNames) {
            carName = carName.trim();
            validateCarNameLength(carName);
            validateDuplicateName(carName, distinctCarNames);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5 || carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicateName(String carName, Set<String> distinctCarNames) {
        if (!distinctCarNames.add(carName)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_EXCEPTION.getMessage());
        }
    }

    private void validateNumericValue(String movementTime) {
        if (!Pattern.matches(NUMERIC_PATTERN, movementTime)) {
            throw new IllegalArgumentException(ErrorMessage.MOVEMENT_TIME_TYPE_EXCEPTION.getMessage());
        }
    }
}

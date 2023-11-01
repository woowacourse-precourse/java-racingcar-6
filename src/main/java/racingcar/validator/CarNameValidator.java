package racingcar.validator;

import java.util.List;

import static racingcar.global.GameSymbols.*;
import static racingcar.global.GameConfig.*;
import static racingcar.validator.ErrorMessage.*;

public class CarNameValidator {

    public List<String> validateAndGetCarNames(String userInput) {
        userInput = removeWhiteSpace(userInput);
        validateNotEmpty(userInput);
        validateSeparator(userInput);
        List<String> carNames = splitCarNames(userInput);
        validateLength(carNames);
        validateDuplicate(carNames);
        return carNames;
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NULL.getMessage());
        }
    }

    private void validateSeparator(String userInput) {
        if (!userInput.contains(CAR_NAME_SEPARATOR.getValue())) {
            throw new IllegalArgumentException(INVALID_SEPARATOR.formatMessage(CAR_NAME_SEPARATOR.getValue()));
        }
    }

    private void validateLength(List<String> carNames) {
        if (hasInvalidNameLength(carNames)) {
            throw new IllegalArgumentException(INVALID_LENGTH.formatMessage(CAR_NAME_LIMIT.getValue()));
        }
    }

    private void validateDuplicate(List<String> carNames) {
        if (hasDuplicates(carNames)) {
            throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
        }
    }

    private static boolean hasInvalidNameLength(List<String> carNames) {
        return carNames.stream()
                .anyMatch(name -> name.length() > CAR_NAME_LIMIT.getValue());
    }

    private static boolean hasDuplicates(List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }

    private List<String> splitCarNames(String userInput) {
        return List.of(userInput.split(CAR_NAME_SEPARATOR.getValue()));
    }

    private String removeWhiteSpace(String userInput) {
        userInput = userInput.replace(" ", "");
        return userInput;
    }
}

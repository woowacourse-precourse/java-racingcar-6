package racingcar.validator;

import static racingcar.validator.ErrorMessage.*;

public class TriesCountValidator {
    public int validateAndGetTriesCount(String userInput) {
        userInput = removeWhiteSpace(userInput);
        validateNotEmpty(userInput);
        int triesCount = parseValidInteger(userInput);
        validatePositive(triesCount);
        return triesCount;
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NULL.getMessage());
        }
    }

    private int parseValidInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_INTEGER.getMessage());
        }
    }

    private void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(INVALID_POSITIVE.getMessage());
        }
    }

    private String removeWhiteSpace(String userInput) {
        userInput = userInput.replace(" ", "");
        return userInput;
    }
}

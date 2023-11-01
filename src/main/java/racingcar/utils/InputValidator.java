package racingcar.utils;

import java.util.List;

public class InputValidator {
    public static void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Message.INPUT_EMPTY_CAR_NAME_ERROR_MESSAGE.getMessage());
        }
    }

    public static void validateInputLength(String input) {
        if (input.length() < 1 || input.length() > 5) {
            throw new IllegalArgumentException(Message.INPUT_CAR_NAME_ERROR_MESSAGE.getMessage());
        }
    }

    public static void validateDuplicateInput(List<String> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException(Message.DUPLICATE_CAR_NAME_ERROR_MESSAGE.getMessage());
        }
    }

    public static int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INPUT_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }
}

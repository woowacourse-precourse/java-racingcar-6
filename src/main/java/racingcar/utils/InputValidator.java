package racingcar.utils;

import java.util.List;

public class InputValidator {

    private static final int MINIMUM_CAR_COUNT = 1;
    private static final int MIN_CAR_NAME_COUNT = 1;
    private static final int MAX_CAR_NAME_COUNT = 5;

    public static void validateCarCountForRace(int carCount) {
        if (carCount == MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_RACE_MINIMUM_CAR_MESSAGE.getMessage());
        }
    }

    public static void validateEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Message.ERROR_EMPTY_CAR_NAME_MESSAGE.getMessage());
        }
    }

    public static void validateInputLength(String input) {
        if (input.length() < MIN_CAR_NAME_COUNT || input.length() > MAX_CAR_NAME_COUNT) {
            throw new IllegalArgumentException(Message.ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE.getMessage());
        }
    }

    public static void validateDuplicateInput(List<String> carList) {
        if (carList.size() != carList.stream().distinct().count()) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_CAR_NAME_MESSAGE.getMessage());
        }
    }

    public static int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NON_NUMBERIC_MOVE_COUNT_MESSAGE.getMessage());
        }
    }

    public static void validateMoveCountInput(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(Message.ERROR_INVALID_MOVE_COUNT_EXCEPTION.getMessage());
        }
    }
}

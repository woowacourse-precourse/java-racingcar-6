package racingcar.util;

import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;

    public static boolean isValidCarNameLength(String input) {
        if(isEmptyInput(input)) return false;
        if(isInvalidNameLength(input)) return false;
        return true;
    }

    public static boolean isNumeric(String input) {
        if(isEmptyInput(input)) return false;
        return input.chars().allMatch(Character::isDigit);
    }

    public static boolean hasDuplicateCarName(List<String> carNames) {
        if(Set.copyOf(carNames).size() == carNames.size()) {
            return false;
        }
        return true;
    }

    public static boolean isValidAllCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (!isValidCarNameLength(carName)) return false;
        }
        return true;
    }

    private static boolean isEmptyInput(final String input) {
        if (input == null || input.isBlank()) {
            return true;
        }
        return false;
    }

    private static boolean isInvalidNameLength(String input) {
        if(input.length() < MIN_CAR_NAME_LENGTH || input.length() > MAX_CAR_NAME_LENGTH) return true;
        return false;
    }
}

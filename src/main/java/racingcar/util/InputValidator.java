package racingcar.util;

import java.util.List;
import java.util.Set;

public class InputValidator {

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
        final String DUPLICATE_CAR_NAME = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

        Set<String> sets = Set.copyOf(carNames);
        if(sets.size() == carNames.size()) {
            return false;
        }

        return true;
    }

    public static boolean isValidAllCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if(!isValidCarNameLength(carName)) {
                return false;
            }
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
        if(input.length() < 1 || input.length() > 5) return true;
        return false;
    }
}

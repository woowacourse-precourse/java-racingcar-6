package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.ErrorMessage;

public class Validator {
    public static void validateCarName(List<String> names) {
        int len = names.stream().filter(name -> name.length() > 5).toList().size();
        if (len > 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_MUST_BE_5_CHARACTERS_LESS.getMessage());
        }
    }

    public static void validateNotDuplicate(List<String> names) {
        Set<String> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_MUST_BE_NOT_DUPLICATED.getMessage());
        }
    }

    public static void validateNoSpace(List<String> names) {
        if (names.contains("") || names.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_MUST_NO_SPACE.getMessage());
        }
    }

    public static void validateNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit) || number.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_MUST_BE_NUMBER.getMessage());
        }
    }

    public static void validateNotZero(String number) {
        if(number.equals("0")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_ZERO.getMessage());
        }
    }
}

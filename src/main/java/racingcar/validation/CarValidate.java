package racingcar.validation;

import java.util.List;

public class CarValidate {
    private final static int MAX_LENGTH = 5;

    public static void carNames(List<String> names) {
        names.forEach(name -> {
            validateNoWhiteSpaceInCarName(name);
            validateCarNameLength(name);
        });
        validateNameDuplication(names);
    }

    public static void participantCount(List<String> names) {
        if (names.size() > 10) {
            throw new IllegalArgumentException(ErrorMessage.PARTICIPANT_COUNT_ERROR.getMessage());
        }
    }

    private static void validateCarNameLength(String name) {
        if(name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    private static void validateNoWhiteSpaceInCarName(String name) {
        if(name.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_WHITESPACE_ERROR.getMessage());
        }
    }

    private static void validateNameDuplication(List<String> names) {
        if(names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATE_ERROR.getMessage());
        }
    }
}

package racingcar.validation;

import java.util.List;

public class InputValidate {
    private final static int MAX_LENGTH = 5;

    public static void nameFormat(String input) {
        if(input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_FORMAT_ERROR.getMessage());
        }
    }

    public static void carNames(List<String> names) {
        names.forEach(name -> {
            validateNoWhiteSpaceInCarName(name);
            validateCarNameLength(name);
        });
        validateNameDuplication(names);
    }

    public static void gameRound(String input) {
        validateInteger(input);
        int round = Integer.parseInt(input);
        validateRoundLength(round);
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

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_INPUT_ERROR.getMessage());
        }
    }

    private static void validateRoundLength(int round) {
        if(round < 1 || round > 20) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_LENGTH_ERROR.getMessage());
        }
    }
}

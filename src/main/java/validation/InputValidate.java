package validation;

import java.util.List;

public class InputValidate {
    private final static int MAX_LENGTH = 5;
    public static void carNames(List<String> names) {
        names.forEach(InputValidate::validateCarNameLength);
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

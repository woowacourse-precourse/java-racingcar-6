package racingcar.validation;

public class InputValidate {
    public static void nameFormat(String input) {
        if(input.contains(",,") || input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_FORMAT_ERROR.getMessage());
        }

        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_FORMAT_ERROR.getMessage());
        }
    }

    public static void gameRound(String input) {
        validateInteger(input);
        int round = Integer.parseInt(input);
        validateRoundLength(round);
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

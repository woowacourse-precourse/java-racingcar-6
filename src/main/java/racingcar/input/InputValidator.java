package racingcar.input;

public class InputValidator {
    public static void isValidCarName(String[] carNames) throws IllegalArgumentException {
        if (carNames.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String name : carNames) {
            isNotEmpty(name);
            isValidLength(name);
        }
    }

    public static void isValidRound(String round) throws IllegalArgumentException {
        isNotEmpty(round);
    }

    private static void isNotEmpty(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열");
        }
    }

    private static void isValidLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("5자 이상");
        }
    }
}

package racingcar.input;

public class InputValidator {
    public static void isValidCarName(String[] carNames) throws IllegalArgumentException {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("빈 문자열");
        }
        for (String name : carNames) {
            isNotEmpty(name);
            isValidLength(name);
        }
    }

    private static void isNotEmpty(String carName) {
        if (carName == null || carName.isEmpty() || carName.isBlank()) {
            throw new IllegalArgumentException("빈 문자열");
        }
    }

    private static void isValidLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("5자 이상");
        }
    }
}

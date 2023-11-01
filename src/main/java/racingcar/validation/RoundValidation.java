package racingcar.validation;

public class RoundValidation {
    public static final String ERROR_GAP = "[ERROR] 공백 없이 입력해주세요.";

    public static final String ERROR_ONLY_INTEGER = "[ERROR] 정수만 입력해주세요.";

    public static final String ERROR_ONE_MORE = "[ERROR] 1이상으로 입력해주세요.";

    public void validateRoundAll(String userInput) {
        validateGap(userInput);
        validateOnlyInteger(userInput);
        validateNumberOfRoundLimit(userInput);
    }

    public void validateGap(String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(ERROR_GAP);
        }
    }

    public void validateOnlyInteger(String userInput) {
        if (!userInput.matches("-?\\d+")) {
            throw new IllegalArgumentException(ERROR_ONLY_INTEGER);
        }
    }

    public void validateNumberOfRoundLimit(String userInput) {
        if (Integer.parseInt(userInput) < 1) {
            throw new IllegalArgumentException(ERROR_ONE_MORE);
        }
    }
}

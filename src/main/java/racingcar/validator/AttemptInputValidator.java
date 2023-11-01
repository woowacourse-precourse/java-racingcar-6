package racingcar.validator;

public class AttemptInputValidator {
    public static int validateAttemptsNumber(String attemptsNumberString) {
        try {
            return Integer.parseInt(attemptsNumberString);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("입력 값이 유효하지 않습니다.");
        }
    }
}

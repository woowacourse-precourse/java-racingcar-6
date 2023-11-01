package racingcar.validation;

public class NumberValidator {

    public static void validateAttemptCount(String userInput) {
        if (!userInput.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        if (Integer.parseInt(userInput) < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 숫자여야 합니다.");
        }
    }

}
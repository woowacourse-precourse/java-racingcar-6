package racingcar.model;

public class AttemptCountValidator {

    public static int validateAttemptCount(String input) {
        validateNoEmpty(input);
        validateIsNumber(input);
        int number = convertToNumber(input);
        validateIsPositive(number);
        return number;
    }


    public static void validateNoEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    public static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력값을 숫자로 변환할 수 없습니다.");
        }
    }

    public static void validateIsPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}

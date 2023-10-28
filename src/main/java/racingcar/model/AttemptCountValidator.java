package racingcar.model;

public class AttemptCountValidator {

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

    public static void validateIsPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}

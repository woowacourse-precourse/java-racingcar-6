package racingcar.validation;

public class Triesvalidator {
    public static void validate(String input) {
        try {
            int tries = Integer.parseInt(input);
            if (tries <= 0) {
                throw new IllegalArgumentException("시도할 회수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자여야 합니다.");
        }
    }
}

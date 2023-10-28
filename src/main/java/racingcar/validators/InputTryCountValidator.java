package racingcar.validators;

public class InputTryCountValidator {
    public static void validateTryCount(String count) {
        validateType(count);
        validateNegativeNumber(count);
    }

    private static void validateType(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수로 숫자만 올 수 있습니다.");
        }
    }

    private static void validateNegativeNumber(String count) {
        if(Integer.parseInt(count) < 0) {
            throw new IllegalArgumentException("시도할 회수로 음수가 올 수 없습니다.");
        }
    }
}

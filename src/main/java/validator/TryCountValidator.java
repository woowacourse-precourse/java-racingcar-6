package validator;

public class TryCountValidator {
    private static final String TYPE_ERROR_MESSAGE = "[ERROR] 숫자만 입력해 주세요.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 최소 1번은 시도해야 합니다.";
    private static final int MIN_COUNT = 1;

    public static String validateTryCount(String tryCount) {
        validateType(tryCount);
        validateRange(tryCount);
        return tryCount;
    }

    private static void validateType(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    private static void validateRange(String tryCount) {
        if (Integer.parseInt(tryCount) < MIN_COUNT) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }
}

package validator;

public class TryCountValidator extends CommonValidator {

    public static void validateString(String tryCount) {
        try {
            convertToInteger(tryCount);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다. 애플리케이션을 종료합니다.");
        }
    }

    public static void validateEmpty(String tryCount) {
        if (tryCount.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수가 빈 값입니다. 애플리케이션을 종료합니다.");
        }
    }

    public static void validateTryCountIncludeEmpty(String tryCount) {
        validateIncludeEmpty(tryCount);
    }

    public static void validateNatureNumber(int tryCount) {
        if (isLessThanOne(tryCount)) {
            throw new IllegalArgumentException("시도 횟수가 양의 정수가 아닙니다. 애플리케이션을 종료합니다.");
        }
    }

    private static boolean isLessThanOne(int tryCount) {
        return tryCount < 1;
    }

    private static void convertToInteger(String tryCount) {
        Integer.parseInt(tryCount);
    }
}

package racingcar.valid;

public class TryCountValidator {
    private static final int MIN_TRY_COUNT = 1;

    public static void validate(String tryCount) {
        int tryCountInteger = isIntegerValidate(tryCount);
        minTryCountValidate(tryCountInteger);
    }

    private static int isIntegerValidate(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }

    private static void minTryCountValidate(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
        }
    }
}

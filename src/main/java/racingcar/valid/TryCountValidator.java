package racingcar.valid;

public class TryCountValidator {
    private static final int MIN_TRY_COUNT = 1;

    public static void validate(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
        }
    }
}

package racingcar.common.validator;

public class TrialCountValidator {
    private static final int MIN_TRIAL_COUNT = 1;
    private static final int MAX_TRIAL_COUNT = Integer.MAX_VALUE;

    public static void validate(int count) {
        validateNonPositive(count);
        validateMaxValue(count);
    }

    //양수가 아닌 경우 검증
    private static void validateNonPositive(int count) {
        if (count < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 " + MIN_TRIAL_COUNT + " 이상이어야 합니다.");
        }
    }

    //정수 최대값보다 작은지 검증
    private static void validateMaxValue(int count) {
        if (count == MAX_TRIAL_COUNT) {
            throw new IllegalArgumentException("시도 횟수가 너무 큽니다. " + MAX_TRIAL_COUNT + "보다 작은 값을 입력해주세요.");
        }
    }
}

package racingcar.exception;

public class TrialCountValidator {

    public static final Integer MIN_TRIAL = 1;
    public static final String SMALLER_THAN_MIN_NUMBER_MSG = MIN_TRIAL + " 이상의 정수값만 입력할 수 있습니다.";

    private TrialCountValidator() {
    }

    public static void validateTrialCount(Integer number) {
        if (isLessThanMinTrial(number)) {
            throw new IllegalArgumentException(SMALLER_THAN_MIN_NUMBER_MSG);
        }
    }

    private static boolean isLessThanMinTrial(Integer number) {
        return number < MIN_TRIAL;
    }
}
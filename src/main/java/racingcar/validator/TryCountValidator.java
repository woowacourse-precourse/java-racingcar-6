package racingcar.validator;

public class TryCountValidator {

    private static final int CHECK_IF_TRY_COUNT_LESS_THAN_ZERO = 0;
    public static final String NUM_REGEX = "^[0-9]*$";
    private static final String TRY_INPUT_TYPE_ERROR = "시도 횟수는 0부터 9 사이의 숫자로만 구성되어야 합니다.";
    private static final String TRY_COUNT_ERROR = "시도 횟수는 0회 이상이어야 합니다.";

    public static void checkAllTryCountException(String tryCount){
        checkTryCount(Integer.parseInt(tryCount));
        checkTryCountType(tryCount);
    }

    public static void checkTryCount(int tryCount) {
        if (tryCount < CHECK_IF_TRY_COUNT_LESS_THAN_ZERO) {
            throw new IllegalArgumentException(TRY_COUNT_ERROR);
        }
    }

    public static void checkTryCountType(String tryCount){
        if(!tryCount.matches(NUM_REGEX)){
            throw new IllegalArgumentException(TRY_INPUT_TYPE_ERROR);
        }
    }
}

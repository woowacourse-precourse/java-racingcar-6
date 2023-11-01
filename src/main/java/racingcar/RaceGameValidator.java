package racingcar;

public class RaceGameValidator {
    private static final int MINIMUM_TRY_NUM = 1;

    public void tryNum(int tryNum) {
        if (tryNum < MINIMUM_TRY_NUM) {
            throw new IllegalArgumentException(ErrorMessages.TOO_LOW_TRY_NUM_ERROR_MESSAGE);
        }
    }
}

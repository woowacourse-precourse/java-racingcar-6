package racingcar.utils;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > Constants.MAXIMUM_NAME_LENGTH) {
                throw new IllegalArgumentException(Constants.NAME_LENGTH_EXCEED);
            }
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(Constants.INVALID_TRY_COUNT);
        }
    }
}

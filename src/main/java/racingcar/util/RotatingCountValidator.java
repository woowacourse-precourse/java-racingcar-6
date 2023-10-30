package racingcar.util;

public class RotatingCountValidator {
    private final String REGEX = "[0-9]+";
    private final int HUNDRED_MILLION = 9;
    public boolean check(String racingCount) {
        return isNull(racingCount) && isSize(racingCount) && isNumber(racingCount);
    }

    private boolean isNumber(String racingCount) {
        return racingCount.matches(REGEX);
    }

    private boolean isSize(String racingCount) {
        return !racingCount.isEmpty() && racingCount.length() <= HUNDRED_MILLION;
    }

    private boolean isNull(String racingCount) {
        return racingCount != null && !racingCount.trim().isEmpty();
    }
}

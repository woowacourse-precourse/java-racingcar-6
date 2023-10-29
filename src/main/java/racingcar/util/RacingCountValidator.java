package racingcar.util;

public class RacingCountValidator {
    private final String regex = "[0-9]+";
    public boolean check(String racingCount) {
        return isNull(racingCount) && isSize(racingCount) && isNumber(racingCount);
    }

    private boolean isNumber(String racingCount) {
        return racingCount.matches(regex);
    }

    private boolean isSize(String racingCount) {
        return !racingCount.isEmpty() && racingCount.length() <= 9;
    }

    private boolean isNull(String racingCount) {
        return racingCount != null && !racingCount.trim().isEmpty();
    }
}

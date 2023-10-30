package racingcar.util;

public class RotatingCountValidator {
    public boolean check(String racingCount) {
        return isNull(racingCount) && isSize(racingCount) && isNumber(racingCount);
    }

    private boolean isNumber(String racingCount) {
        String regex = "[0-9]+";
        return racingCount.matches(regex);
    }

    private boolean isSize(String racingCount) {
        int hundredMillion = 9;
        return !racingCount.isEmpty() && racingCount.length() <= hundredMillion;
    }

    private boolean isNull(String racingCount) {
        return racingCount != null && !racingCount.trim().isEmpty();
    }
}

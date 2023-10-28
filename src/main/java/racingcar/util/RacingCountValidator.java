package racingcar.util;

public class RacingCountValidator {
    private final String regex = "^[0-9]+$";
    public boolean check(String racingCount) {
        if(isNull(racingCount) && isSize(racingCount) && isNumber(racingCount)){
            return true;
        }
        throw new IllegalArgumentException("잘못된 시도 횟수를 입력하였습니다.");
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

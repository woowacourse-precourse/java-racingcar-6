package racingcar.validator;

public class TryCountValidator {

    public void isNumber(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    public void isZero(String tryCount) {
        if (Integer.parseInt(tryCount) == 0) {
            throw new IllegalArgumentException("경주는 최소 1회 이상 시도되어야 합니다");
        }
    }
}

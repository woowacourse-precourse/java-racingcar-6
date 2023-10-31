package racingcar.validator;

public class TryCountValidator {

    public void isNumber(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }
}

package racingcar.validator;

public class TryCountValidator {

    public void isNumber(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다 : 0에서 9사이의 숫자를 입력해주세요");
        }
    }

    public void isNumberInRange(String tryCount) {
        int tmpCount = Integer.parseInt(tryCount);
        if (tmpCount < 0 || tmpCount > 9) {
            throw new IllegalArgumentException("범위 내의 숫자가 아닙니다 : 0에서 9사이의 숫자를 입력해주세요");
        }
    }
}

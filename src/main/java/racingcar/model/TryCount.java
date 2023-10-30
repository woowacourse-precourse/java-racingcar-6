package racingcar.model;

public class TryCount {

    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String ZERO_REGEX = "^0$";

    private final int count;

    public TryCount(String count) {
        validateNumber(count);
        validateZero(count);
        this.count = Integer.parseInt(count);
    }

    private void validateNumber(String count) {
        if (!count.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validateZero(String count) {
        if (count.matches(ZERO_REGEX)) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요.");
        }
    }

    public int value() {
        return count;
    }
}
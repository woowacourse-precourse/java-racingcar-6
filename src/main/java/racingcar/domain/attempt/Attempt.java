package racingcar.domain.attempt;

public class Attempt {

    private static final int INPUT_MINIMUM_VALUE = 1;
    private static final int ATTEMPT_MINIMUM_VALUE = 0;
    private static final String ERROR_MESSAGE_TOO_LOW = "최소 1 이상의 값을 입력해 주세요.";
    private static final String ERROR_MESSAGE_CANNOT_EXECUTE = "모든 시도 횟수를 소모하셨습니다.";

    private int value;

    public Attempt(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int input) {
        if (input < INPUT_MINIMUM_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TOO_LOW);
        }
    }

    public void use() {
        if (!hasNext()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CANNOT_EXECUTE);
        }
        value -= 1;
    }

    public boolean hasNext() {
        if (value <= ATTEMPT_MINIMUM_VALUE) {
            return false;
        }
        return true;
    }
}

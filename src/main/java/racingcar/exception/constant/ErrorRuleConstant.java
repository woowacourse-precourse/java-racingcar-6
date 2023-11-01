package racingcar.exception.constant;

public enum ErrorRuleConstant {
    CAR_NAME_LENGTH_MIN_RANGE(1),
    CAR_NAME_LENGTH_MAX_RANGE(5);

    private final int number;

    ErrorRuleConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

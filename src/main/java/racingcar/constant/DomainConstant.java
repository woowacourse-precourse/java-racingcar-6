package racingcar.constant;

public enum DomainConstant {
    LAP_MIN_SIZE(0),
    LAP_INCREASE_COUNT(1),

    EXTRACT_TRACK_MIN_SIZE(0),
    EXTRACT_TRACK_DECREASE(1),
    CAR_NAME_SIZE(5);
    private final int value;

    DomainConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

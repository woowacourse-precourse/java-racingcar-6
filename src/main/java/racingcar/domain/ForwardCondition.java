package racingcar.domain;

public enum ForwardCondition {

    MOVABLE_OFFSET(4),
    FORWARD_AMOUNT(1);

    private final int value;

    ForwardCondition(final int value) {
        this.value = value;
    }

    public static boolean isMovableNumber(final int number) {
        return MOVABLE_OFFSET.value <= number;
    }

    public int getValue() {
        return value;
    }
}

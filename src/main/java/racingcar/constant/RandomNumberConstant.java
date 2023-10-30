package racingcar.constant;

public enum RandomNumberConstant {

    MOVE_FORWARD(4),
    ZERO(0), NINE(9);

    private final int number;

    RandomNumberConstant(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}

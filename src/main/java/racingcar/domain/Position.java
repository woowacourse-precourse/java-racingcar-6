package racingcar.domain;

public class Position {
    public static final int FORWARD_VALUE = 1;
    private int value;

    public Position() {
    }

    public Position(int value) {
        this.value = value;
    }

    Position goForward() {
        return new Position(this.value + FORWARD_VALUE);
    }

    int getValue() {
        return this.value;
    }
}

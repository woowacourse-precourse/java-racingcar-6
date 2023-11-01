package racingcar.domain;

public class Position {
    private static final int START_POSITION = 0;
    private int value;

    public Position() {
        this.value = START_POSITION;
    }

    public Position(int value) {
        this.value = value;
    }

    public void goForward() {
        this.value++;
    }

    int getValue() {
        return this.value;
    }
}

package racingcar;

public class Position {
    private int value;

    public Position() {
    }

    public Position(int value) {
        this.value = value;
    }

    void goForward() {
        this.value++;
    }

    int getValue() {
        return this.value;
    }
}

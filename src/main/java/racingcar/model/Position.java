package racingcar.model;

public class Position {
    private int value;

    public Position() {
        this.value = 0;
    }

    public void add() {
        value++;
    }

    public int getValue() {
        return value;
    }
}

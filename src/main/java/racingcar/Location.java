package racingcar;

public class Location {
    private int value;

    Location() {
        this.value = 0;
    }

    void move() {
        value++;
    }

    public int getValue() {
        return value;
    }
}
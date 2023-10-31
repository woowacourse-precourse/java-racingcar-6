package racingcar.domain;

public class Position {
    private static final int START_POSITION = 0;

    private int position;

    public Position() {
        this.position = START_POSITION;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int toInt() {
        return this.position;
    }
}

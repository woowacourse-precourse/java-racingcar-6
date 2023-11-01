package racingcar.domain;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public void increase() {
        position++;
    }

    public int compareTo(Position other) {
        return this.position - other.position;
    }

    public int getPosition() {
        return position;
    }
}

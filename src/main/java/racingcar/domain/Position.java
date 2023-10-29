package racingcar.domain;

public class Position implements Comparable<Position> {

    private int position;
    private static final int INITIAL_POSITION = 0;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void move() {
        position++;
    }

    @Override
    public int compareTo(Position other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Position other) {
        return this.position == other.position;
    }

    public int getLawPosition() {
        return position;
    }
}

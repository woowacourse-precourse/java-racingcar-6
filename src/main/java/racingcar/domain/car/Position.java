package racingcar.domain.car;

public class Position implements Comparable<Position> {
    private static final int START_POSITION = 0;
    private static final String POSITION_SYMBOL = "-";

    private int position = START_POSITION;

    @Override
    public String toString() {
        return POSITION_SYMBOL.repeat(position);
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Position otherPosition) {
            return this.position == otherPosition.position;
        }

        return false;
    }

    public void increase() {
        position++;
    }
}


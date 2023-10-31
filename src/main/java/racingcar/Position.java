package racingcar;

public class Position implements Comparable<Position> {
    private final int x;

    Position(int x) {
        this.x = x;
    }

    static Position of(int x) {
        return new Position(x);
    }

    Position forward(int dx) {
        return new Position(x + dx);
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        Position otherPosition = (Position) obj;
        return this.x == otherPosition.x;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(x);
    }

    @Override
    public int compareTo(Position other) {
        return this.x - other.x;
    }
}

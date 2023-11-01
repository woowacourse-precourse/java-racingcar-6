package racingcar.game.domain;

public class Position implements Comparable<Position> {
    private final int x;

    Position(int x) {
        this.x = x;
    }

    public static Position of(int x) {
        return new Position(x);
    }

    public Position forward(int dx) {
        return new Position(x + dx);
    }

    @Override
    public int compareTo(Position other) {
        return this.x - other.x;
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

    public int getX() {
        return x;
    }
}

package racingcar.domain.position;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move(int weight) {
        this.position += weight;
    }

    public String draw() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.position, o.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

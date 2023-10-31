package racingcar.domain.position;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private int value;

    public Position(int value) {
        this.value = value;
    }

    public void move(int weight) {
        this.value += weight;
    }

    public int getValue() {
        return value;
    }

    public String draw() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value; i++) {
            result.append("-");
        }
        return result.toString();
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.value, o.value);
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
        return this.value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

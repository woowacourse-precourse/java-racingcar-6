package racingcar.car;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public String getPositionText() {
        return Stream.generate(() -> "-")
                .limit(position)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}

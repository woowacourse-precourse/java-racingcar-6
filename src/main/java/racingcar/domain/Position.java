package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position>{

    private static final String POSITION_ERROR = "[ERROR] 위치는 0 이상이어야 합니다.";
    private static final int DEFAULT_POSITION = 0;
    private final int value;

    public Position(int position) {

        if (position < DEFAULT_POSITION) {
            throw new IllegalArgumentException(POSITION_ERROR);
        }
        this.value = position;
    }

    public Position move() {

        return new Position(value + 1);
    }

    public int value() {

        return value;
    }

    @Override
    public int compareTo(Position compareTarget) {

        return Integer.compare(this.value, compareTarget.value);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}

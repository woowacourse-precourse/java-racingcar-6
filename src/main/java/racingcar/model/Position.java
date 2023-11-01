package racingcar.model;

import java.util.Objects;

public class Position {
    private static final int BASE_POSITION = 0;
    private static final int MOVE_SIZE = 1;
    private static final String DISPLAY_STRING = "-";
    private int position;

    public Position() {
        position = BASE_POSITION;
    }

    //테스트 코드용 생성자
    public Position(int testNumber) {
        this.position = testNumber;
    }

    public void move() {
        this.position += MOVE_SIZE;
    }

    public String format() {
        return DISPLAY_STRING.repeat(position);
    }

    public boolean isGreaterThan(Position other) {
        return this.position > other.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position that = (Position) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}

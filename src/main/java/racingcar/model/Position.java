package racingcar.model;

import static racingcar.constant.Message.CAR_POSITION_CHECK;
import static racingcar.constant.Number.MOVE_SIZE;
import static racingcar.constant.Number.START_POSITION;

import java.util.Objects;

public class Position {

    private int position;

    public Position() {
        position = START_POSITION;
    }

    public void move() {
        this.position += MOVE_SIZE;
    }

    public String format() {
        return CAR_POSITION_CHECK.repeat(position);
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

    // 테스트 코드용
    public Position(int testNumber) {
        this.position = testNumber;
    }
}

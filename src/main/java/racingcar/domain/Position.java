package racingcar.domain;

public class Position {
    private static final String INVALID_POSITION_RANGE = "음수는 위치 값이 될 수 없습니다.";
    private int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(INVALID_POSITION_RANGE);
        }
        this.position = position;
    }

    public Position() {
        this(0);
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}

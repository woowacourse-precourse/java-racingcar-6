package racingcar.domain.car;

import racingcar.domain.Movement;

public class Position {
    private static final int INITIAL_POSITION = 0;
    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void move(Movement movement) {
        this.position += movement.getAddingValue();
    }

    public int getValue() {
        return position;
    }
}

package racingcar.domain.wrapper;

import static racingcar.domain.constant.CarConstant.INIT_POSITION;

public class Position {
    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position create() {
        return new Position(INIT_POSITION.getValue());
    }

    public void addPosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}

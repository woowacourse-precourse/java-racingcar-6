package racingcar.domain.wrapper;

import static racingcar.handler.ConstantsHandler.INIT_POSITION;

public class CarPosition {

    private int position;

    private CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition create() {
        return new CarPosition(INIT_POSITION);
    }

    public void addPosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}

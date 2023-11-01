package racingcar.domain;

import racingcar.domain.constant.CarConstant;

public class Position {
    private int position = CarConstant.INIT_POSITION;

    public void moveForward(int distance) {
        position += distance;
    }

    public int toInt() {
        return this.position;
    }

}
